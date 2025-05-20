package com.frukas.warehouse.controller;

import com.frukas.warehouse.dto.CategoryDTO;
import com.frukas.warehouse.dto.CategoryResponseDTO;
import com.frukas.warehouse.mapper.CategoryMapper;
import com.frukas.warehouse.model.Category;
import com.frukas.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok( CategoryMapper.toCategoryResponse(categoryService.find(id)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll(@RequestParam int pag,
                                                              @RequestParam int qtd){
        return ResponseEntity.ok(
                categoryService.findAll(PageRequest.of(pag, qtd)).stream().map(CategoryMapper::toCategoryResponse).toList()
        );
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.save(CategoryMapper.toCategory(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id){
        if(!category.getId().equals(id)){
           return ResponseEntity.badRequest().body(category);
        }
        return ResponseEntity.ok(categoryService.update(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        categoryService.remove(id);

        return  ResponseEntity.ok("Entry successfully deleted " + id);
    }


}

