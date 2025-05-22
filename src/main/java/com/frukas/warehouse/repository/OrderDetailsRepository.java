package com.frukas.warehouse.repository;

import com.frukas.warehouse.model.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    Optional<OrderDetails> findByIdAndIsActiveTrue(Long id);

    Page<OrderDetails> findByIsActiveTrue(Pageable pageable);
}
