package com.frukas.warehouse.dto;


public record ProductDTO(Long id,String name, Long categoryId,double price, int quantity) {
}
