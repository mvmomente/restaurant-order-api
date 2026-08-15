package com.mvmomente.restaurant_order_api.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        String description,
        BigDecimal price
){
}
