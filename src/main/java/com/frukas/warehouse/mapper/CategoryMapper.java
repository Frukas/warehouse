package com.frukas.warehouse.mapper;

import com.frukas.warehouse.dto.CategoryDTO;
import com.frukas.warehouse.dto.CategoryResponseDTO;
import com.frukas.warehouse.model.Category;

public class CategoryMapper {

    private CategoryMapper(){}

    public static CategoryDTO toDTO(Category category){
        if(category == null)
            return null;

        return new CategoryDTO(category.getId(), category.getName(), category.getSerialNumber() );
    }

    public static Category toCategory(CategoryDTO categoryDTO){
        if(categoryDTO == null)
            return null;

        Category category = new Category();
        category.setId(categoryDTO.id());
        category.setName(categoryDTO.name());
        category.setSerialNumber(categoryDTO.serialNumber());

        return category;
    }

    public static CategoryResponseDTO toCategoryResponse(Category category){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getSerialNumber(),
                category.getCreatedUpdateTime().getUpdateAt());
    }
}
