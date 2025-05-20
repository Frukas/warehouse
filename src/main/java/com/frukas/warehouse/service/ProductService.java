package com.frukas.warehouse.service;

import com.frukas.warehouse.exceptions.ResourceNotFound;
import com.frukas.warehouse.exceptions.ResourceNotSaved;
import com.frukas.warehouse.model.Category;
import com.frukas.warehouse.model.CreatedUpdateTime;
import com.frukas.warehouse.model.Product;
import com.frukas.warehouse.repository.CategoryRepository;
import com.frukas.warehouse.repository.ProductRepository;
import com.frukas.warehouse.util.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product find(Long id){

       return productRepository.findByIdAndIsActiveTrue(id).orElseThrow(
               () -> new ResourceNotFound("Category Not Found - id: " + id ));
    }

    public List<Product> findAll(Pageable pageable){
        return productRepository.findByIsActiveTrue(pageable).toList();
    }

    public Product save(Product product){
        try{
            product.setCreatedUpdateTime(new CreatedUpdateTime());
            DateHandler.setCreatedUpdated(product.getCreatedUpdateTime());

            return productRepository.save(product);
        }catch (Exception e){
            throw new ResourceNotSaved("Product not saved " + e.getMessage());
        }
    }

    public Product update(Product product){
        try{
            Product temp = productRepository.findById(product.getId()).orElseThrow(
                    () -> new ResourceNotFound("Category Not Found - id: " + product.getId() ));

            DateHandler.setCreatedUpdated(temp.getCreatedUpdateTime());

            product.setCreatedUpdateTime(temp.getCreatedUpdateTime());
            return productRepository.save(product);
        }catch (Exception e){
            throw new ResourceNotSaved("Category not updated " + product.getId());
        }
    }

    public void remove(Long id){
        Product temp = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Not possible delete - id: " + id ));
        try{
            temp.setActive(false);
            productRepository.save(temp);
        }catch(Exception e){
            throw new ResourceNotFound("Not possible delete - id: " + id );
        }
    }
}
