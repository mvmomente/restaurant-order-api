package com.mvmomente.restaurant_order_api.repository;

import com.mvmomente.restaurant_order_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}
