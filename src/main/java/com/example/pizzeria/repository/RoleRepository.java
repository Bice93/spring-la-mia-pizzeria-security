package com.example.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzeria.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
