package com.frukas.warehouse.controller;

import com.frukas.warehouse.dto.OrderDetailsDTO;
import com.frukas.warehouse.dto.OrderDetailsResponseDTO;
import com.frukas.warehouse.mapper.OrderDetailsMapper;
import com.frukas.warehouse.model.OrderDetails;
import com.frukas.warehouse.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService){
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsResponseDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(OrderDetailsMapper.toOrderDetailsResponse(orderDetailsService.find(id)));
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailsResponseDTO>> findAll(@RequestParam int pag,
                                                            @RequestParam int qtd){
        return ResponseEntity.ok(
                orderDetailsService.findAll(
                        PageRequest.of(pag, qtd)).stream().map(OrderDetailsMapper::toOrderDetailsResponse).toList()
        );
    }

    @PostMapping
    public ResponseEntity<OrderDetails> save(@RequestBody OrderDetailsDTO dto){

        return ResponseEntity.ok(orderDetailsService.save(OrderDetailsMapper.toOrderDetails(dto)) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> update(@RequestBody OrderDetailsDTO dto, @PathVariable Long id){
        if(!dto.id().equals(id)){
            return ResponseEntity.badRequest().body( OrderDetailsMapper.toOrderDetails(dto));
        }

        return ResponseEntity.ok(orderDetailsService.update(OrderDetailsMapper.toOrderDetails(dto)) );
    }
}
