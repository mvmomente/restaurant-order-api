package com.mvmomente.restaurant_order_api.service;

import com.mvmomente.restaurant_order_api.dto.request.ProductRequestDTO;
import com.mvmomente.restaurant_order_api.dto.response.ProductResponseDTO;
import com.mvmomente.restaurant_order_api.entity.Product;
import com.mvmomente.restaurant_order_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductResponseDTO toDto(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO dto) {
        Product product = new Product();

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        Product saved = productRepository.save(product);

        return toDto(saved);
    }

    public ProductResponseDTO findById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return toDto(product);
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public void deleteProduct(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        productRepository.delete(product);
    }

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        Product updated = productRepository.save(product);

        return toDto(updated);
    }

}
