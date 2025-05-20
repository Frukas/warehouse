package com.frukas.warehouse.dto;

public record OrderDetailsDTO(Long id, Long userId, Long ProductID, int quantity, String OrderStatus) {
}
