package com.frukas.warehouse.dto;

import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id, String Name, String categoryName, double price , int quantity, LocalDateTime date) {
}
