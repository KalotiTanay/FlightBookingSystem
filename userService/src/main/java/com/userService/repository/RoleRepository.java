package com.userService.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userService.model.ERole;
import com.userService.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
