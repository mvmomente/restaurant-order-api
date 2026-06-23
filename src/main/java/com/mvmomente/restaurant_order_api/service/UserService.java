package com.mvmomente.restaurant_order_api.service;

import com.mvmomente.restaurant_order_api.dto.request.UserRequestDTO;
import com.mvmomente.restaurant_order_api.dto.response.UserResponseDTO;
import com.mvmomente.restaurant_order_api.entity.User;
import com.mvmomente.restaurant_order_api.mapper.UserMapper;
import com.mvmomente.restaurant_order_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO saveUser(UserRequestDTO dto) {

        User user = userMapper.toEntity(dto);
        User saved = userRepository.save(user);

        return userMapper.toDto(saved);
    }

    public UserResponseDTO findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return userMapper.toDto(user);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        userRepository.delete(user);
    }

    public UserResponseDTO updateUser(UUID id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        userMapper.updateEntity(dto, user);

        User updated = userRepository.save(user);

        return userMapper.toDto(updated);
    }
}
