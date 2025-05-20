package com.frukas.warehouse.dto;

import java.time.LocalDateTime;

public record CategoryResponseDTO(Long id, String name, String serialNumber, LocalDateTime date) {
}
