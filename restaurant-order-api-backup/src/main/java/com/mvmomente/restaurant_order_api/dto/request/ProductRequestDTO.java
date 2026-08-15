package com.mvmomente.restaurant_order_api.dto.request;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        String description,
        BigDecimal price
){
}