package com.mvmomente.restaurant_order_api.dto.request;

import java.util.UUID;

public record OrderItemRequestDTO(
        UUID productId,
        Integer quantity
) {
}