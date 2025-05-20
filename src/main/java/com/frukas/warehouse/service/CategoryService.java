package com.frukas.warehouse.service;

import com.frukas.warehouse.exceptions.ResourceNotFound;
import com.frukas.warehouse.exceptions.ResourceNotSaved;
import com.frukas.warehouse.model.Category;
import com.frukas.warehouse.model.CreatedUpdateTime;
import com.frukas.warehouse.repository.CategoryRepository;
import com.frukas.warehouse.util.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category find(Long id){

       return categoryRepository.findByIdAndIsActiveTrue(id).orElseThrow(
                () -> new ResourceNotFound("Category Not Found - id: " + id ));

    }

    public List<Category> findAll(Pageable pageable){

        return  categoryRepository.findByIsActiveTrue(pageable).stream().toList();
    }

    public Category save(Category category){
        try{
            category.setCreatedUpdateTime(new CreatedUpdateTime());
            DateHandler.setCreatedUpdated(category.getCreatedUpdateTime());

            return categoryRepository.save(category);
        }catch (Exception e){
            throw new ResourceNotSaved("Category not saved " + category.toString());
        }
    }

    public Category update(Category category){
        try{
            Category temp = categoryRepository.findById(category.getId()).orElseThrow(
                    () -> new ResourceNotFound("Category Not Found - id: " + category.getId() ));

            DateHandler.setCreatedUpdated(temp.getCreatedUpdateTime());

            category.setCreatedUpdateTime(temp.getCreatedUpdateTime());
            return categoryRepository.save(category);
        }catch (Exception e){
            throw new ResourceNotSaved("Category not updated " + category.toString());
        }
    }

    public void remove(Long id){
        Category temp = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Not possible delete - id: " + id ));
        try{
            temp.setActive(false);
            categoryRepository.save(temp);
        }catch(Exception e){
            throw new ResourceNotFound("Not possible delete - id: " + id );
        }
    }
}
