package com.frukas.warehouse.dto;

import com.frukas.warehouse.common.OrderStatus;

public record OrderDetailsDTO(Long id,
                              Long userId,
                              Long ProductID,
                              int quantity,
                              double price,
                              OrderStatus OrderStatus
                              ) {
}
