package com.frukas.warehouse.dto;

import com.frukas.warehouse.common.OrderStatus;

import java.time.LocalDateTime;

public record OrderDetailsResponseDTO(Long id,
                                      Long userID,
                                      String userName,
                                      Long productId,
                                      String productName,
                                      int quantity,
                                      double price,
                                      OrderStatus orderStatus,
                                      LocalDateTime date) {
}
