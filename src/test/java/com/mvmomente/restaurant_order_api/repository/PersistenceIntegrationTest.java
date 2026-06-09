package com.mvmomente.restaurant_order_api.repository;

import com.mvmomente.restaurant_order_api.entity.Order;
import com.mvmomente.restaurant_order_api.entity.OrderItem;
import com.mvmomente.restaurant_order_api.entity.Product;
import com.mvmomente.restaurant_order_api.entity.Role;
import com.mvmomente.restaurant_order_api.entity.User;
import com.mvmomente.restaurant_order_api.enums.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PersistenceIntegrationTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void shouldPersistOrderWithUserRoleProductAndOrderItems() {
        Role role = new Role();
        role.setName("CUSTOMER");
        role = roleRepository.save(role);

        User user = new User();
        user.setName("Maria Silva");
        user.setEmail("maria.silva@example.com");
        user.setPassword("senha123");
        user.setRole(role);
        user = userRepository.save(user);

        Product product = new Product();
        product.setName("Burger");
        product.setDescription("Cheeseburger com queijo e bacon");
        product.setPrice(new BigDecimal("25.00"));
        product = productRepository.save(product);

        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setTotalAmmount(new BigDecimal("50.00"));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(2);
        orderItem.setUnitPrice(product.getPrice());
        orderItem.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));

        order.getItems().add(orderItem);
        order = orderRepository.save(order);

        Assertions.assertThat(order.getId()).isNotNull();
        Assertions.assertThat(order.getItems()).hasSize(1);
        Assertions.assertThat(order.getItems().get(0).getSubtotal()).isEqualByComparingTo(new BigDecimal("50.00"));

        Order persistedOrder = orderRepository.findById(order.getId()).orElseThrow();
        Assertions.assertThat(persistedOrder.getUser()).isNotNull();
        Assertions.assertThat(persistedOrder.getUser().getEmail()).isEqualTo("maria.silva@example.com");
        Assertions.assertThat(persistedOrder.getUser().getRole()).isNotNull();
        Assertions.assertThat(persistedOrder.getUser().getRole().getName()).isEqualTo("CUSTOMER");
        Assertions.assertThat(persistedOrder.getItems()).hasSize(1);
        Assertions.assertThat(persistedOrder.getItems().get(0).getProduct().getName()).isEqualTo("Burger");

        List<OrderItem> allItems = orderItemRepository.findAll();
        Assertions.assertThat(allItems).hasSize(1);
        Assertions.assertThat(allItems.get(0).getOrder().getId()).isEqualTo(order.getId());
    }

    @Test
    void shouldFindUserByEmailAndValidateOrderRelationshipChains() {
        Role role = new Role();
        role.setName("ADMIN");
        role = roleRepository.save(role);

        User user = new User();
        user.setName("Joao Pereira");
        user.setEmail("joao.pereira@example.com");
        user.setPassword("senha456");
        user.setRole(role);
        user = userRepository.save(user);

        Product product = new Product();
        product.setName("Pizza Margherita");
        product.setDescription("Pizza clássica com manjericão");
        product.setPrice(new BigDecimal("30.00"));
        product = productRepository.save(product);

        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.PREPARING);
        order.setTotalAmmount(new BigDecimal("30.00"));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(1);
        item.setUnitPrice(product.getPrice());
        item.setSubtotal(product.getPrice());

        order.getItems().add(item);
        user.getOrders().add(order);
        order = orderRepository.save(order);

        User persistedUser = userRepository.findByEmail("joao.pereira@example.com").orElseThrow();
        Assertions.assertThat(persistedUser.getRole()).isNotNull();
        Assertions.assertThat(persistedUser.getRole().getName()).isEqualTo("ADMIN");
        Assertions.assertThat(persistedUser.getOrders()).hasSize(1);

        Order persistedOrder = persistedUser.getOrders().get(0);
        Assertions.assertThat(persistedOrder.getStatus()).isEqualTo(OrderStatus.PREPARING);
        Assertions.assertThat(persistedOrder.getItems()).hasSize(1);
        Assertions.assertThat(persistedOrder.getItems().get(0).getProduct().getName()).isEqualTo("Pizza Margherita");
    }
}
