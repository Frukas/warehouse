package com.frukas.warehouse.mapper;

import com.frukas.warehouse.dto.ProductDTO;
import com.frukas.warehouse.dto.ProductResponseDTO;
import com.frukas.warehouse.model.Category;
import com.frukas.warehouse.model.Product;

public class ProductMapper {

    private ProductMapper(){}

    public static ProductDTO toDTO(Product product){
        if(product == null)
            return null;

        return new ProductDTO(
                product.getId(), product.getName(), product.getCategory().getId(), product.getPrice(), product.getQuantity());
    }

    public static Product toProduct(ProductDTO productDTO){
        if(productDTO == null)
          return null;

        Category categoryTemp = new Category();
        categoryTemp.setId(productDTO.categoryId());

        Product temp = new Product();
        temp.setId(productDTO.id());
        temp.setName(productDTO.name());
        temp.setCategory(categoryTemp);
        temp.setPrice(productDTO.price());
        temp.setQuantity(productDTO.quantity());

        return temp;
    }

    public static ProductResponseDTO toProductResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getCategory().getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getCreatedUpdateTime().getUpdateAt()
                );
    }
}
