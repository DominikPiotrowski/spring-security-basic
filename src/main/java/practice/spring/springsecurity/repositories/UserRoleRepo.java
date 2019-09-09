package practice.spring.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import practice.spring.springsecurity.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    UserRole findByRole(String role);

}
