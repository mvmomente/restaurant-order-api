package com.mvmomente.restaurant_order_api.controller;

import com.mvmomente.restaurant_order_api.dto.request.ProductRequestDTO;
import com.mvmomente.restaurant_order_api.dto.response.ProductResponseDTO;
import com.mvmomente.restaurant_order_api.entity.Product;
import com.mvmomente.restaurant_order_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable UUID id) {
        ProductResponseDTO product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO dto) {
        ProductResponseDTO savedProduct = productService.saveProduct(dto);

        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable UUID id,
            @RequestBody ProductRequestDTO dtoRequest) {

        ProductResponseDTO updated = productService.updateProduct(id, dtoRequest);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
