package com.mvmomente.restaurant_order_api.mapper;

import com.mvmomente.restaurant_order_api.dto.request.ProductRequestDTO;
import com.mvmomente.restaurant_order_api.dto.response.ProductResponseDTO;
import com.mvmomente.restaurant_order_api.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        return product;
    }

    public ProductResponseDTO toDto(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public void updateEntity(ProductRequestDTO dto, Product product) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
    }
}
