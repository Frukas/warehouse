package com.frukas.warehouse.repository;


import com.frukas.warehouse.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findByIdAndIsActiveTrue(Long id);

    Page<Category> findByIsActiveTrue(Pageable pageable);
}
