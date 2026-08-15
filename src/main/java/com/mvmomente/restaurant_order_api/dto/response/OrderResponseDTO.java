package com.mvmomente.restaurant_order_api.dto.response;

import com.mvmomente.restaurant_order_api.entity.OrderItem;
import com.mvmomente.restaurant_order_api.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDTO(
        UUID id,
        UUID userId,
        LocalDateTime createdAt,
        BigDecimal totalAmmount,
        OrderStatus status,
        List<OrderItemResponseDTO> items
) {
}