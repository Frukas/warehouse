package com.frukas.warehouse.controller;

import com.frukas.warehouse.dto.ProductDTO;
import com.frukas.warehouse.dto.ProductResponseDTO;
import com.frukas.warehouse.mapper.ProductMapper;
import com.frukas.warehouse.model.Product;
import com.frukas.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok( ProductMapper.toProductResponseDTO(productService.find(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll(@RequestParam int pag,
                                                  @RequestParam int qtd){
        return ResponseEntity.ok(
                productService.findAll(
                        PageRequest.of(pag, qtd)).stream().map(ProductMapper::toProductResponseDTO).toList()
        );
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDTO dto){

        return ResponseEntity.ok(productService.save(ProductMapper.toProduct(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO dto, @PathVariable Long id){
        if(!dto.id().equals(id)){
            return ResponseEntity.badRequest().body(ProductMapper.toProduct(dto));
        }

        return ResponseEntity.ok(productService.update(ProductMapper.toProduct(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        productService.remove(id);

        return  ResponseEntity.ok("Entry successfully deleted " + id);
    }
}
