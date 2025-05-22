package com.frukas.warehouse.service;

import com.frukas.warehouse.exceptions.ResourceNotFound;
import com.frukas.warehouse.exceptions.ResourceNotSaved;
import com.frukas.warehouse.model.CreatedUpdateTime;
import com.frukas.warehouse.model.OrderDetails;
import com.frukas.warehouse.repository.OrderDetailsRepository;
import com.frukas.warehouse.util.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository){
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails find(Long id){

        return orderDetailsRepository.findByIdAndIsActiveTrue(id).orElseThrow(
                () -> new ResourceNotFound("Category Not Found - id: " + id ));
    }

    public List<OrderDetails> findAll(Pageable pageable){

        return orderDetailsRepository.findByIsActiveTrue(pageable).toList();
    }

    public OrderDetails save(OrderDetails orderDetails){
        try{

            orderDetails.setCreatedUpdateTime(new CreatedUpdateTime());
            DateHandler.setCreatedUpdated(orderDetails.getCreatedUpdateTime());

            return orderDetailsRepository.save(orderDetails);
        }catch (Exception e){
            throw new ResourceNotSaved("Category not saved " + orderDetails.getId());
        }
    }

    public OrderDetails update(OrderDetails orderDetails){
        try{
            OrderDetails temp = orderDetailsRepository.findById(orderDetails.getId()).orElseThrow(
                    () -> new ResourceNotFound("Category Not Found - id: " + orderDetails.getId() ));

            DateHandler.setCreatedUpdated(temp.getCreatedUpdateTime());

            orderDetails.setCreatedUpdateTime(temp.getCreatedUpdateTime());
            return orderDetailsRepository.save(orderDetails);
        }catch (Exception e){
            throw new ResourceNotSaved("Category not updated " + orderDetails.getId() );
        }
    }

    public void remove(Long id){
        OrderDetails temp = orderDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Not possible delete - id: " + id ));
        try{
            temp.setActive(false);
            orderDetailsRepository.save(temp);
        }catch(Exception e){
            throw new ResourceNotFound("Not possible delete - id: " + id );
        }

    }
}
