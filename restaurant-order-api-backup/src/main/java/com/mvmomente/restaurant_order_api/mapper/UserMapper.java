package com.mvmomente.restaurant_order_api.mapper;

import com.mvmomente.restaurant_order_api.dto.request.UserRequestDTO;
import com.mvmomente.restaurant_order_api.dto.response.UserResponseDTO;
import com.mvmomente.restaurant_order_api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        User user = new User();

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        return user;
    }

    public UserResponseDTO toDto(User user) {
        return new UserResponseDTO(
                user.getName(),
                user.getEmail()
        );
    }

    public void updateEntity(UserRequestDTO dto, User user) {
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
    }
}
