package com.mvmomente.restaurant_order_api.dto.request;

import com.mvmomente.restaurant_order_api.entity.User;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(
        UUID userId,
        List<OrderItemRequestDTO> items
) {
}