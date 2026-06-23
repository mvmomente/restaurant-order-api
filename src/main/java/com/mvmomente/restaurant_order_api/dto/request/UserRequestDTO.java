package com.mvmomente.restaurant_order_api.dto.request;

public record UserRequestDTO(
        String name,
        String email,
        String password
) {
}
