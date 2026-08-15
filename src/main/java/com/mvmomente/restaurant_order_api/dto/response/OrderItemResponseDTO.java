package com.mvmomente.restaurant_order_api.dto.response;

import com.mvmomente.restaurant_order_api.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderItemResponseDTO(
        UUID id,
        UUID productId,
        String productName,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal

) {
}