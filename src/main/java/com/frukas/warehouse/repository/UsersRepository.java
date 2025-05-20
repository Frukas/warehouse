package com.frukas.warehouse.repository;

import com.frukas.warehouse.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
