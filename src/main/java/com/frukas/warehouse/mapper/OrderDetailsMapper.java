package com.frukas.warehouse.mapper;

import com.frukas.warehouse.dto.OrderDetailsDTO;
import com.frukas.warehouse.dto.OrderDetailsResponseDTO;
import com.frukas.warehouse.model.OrderDetails;

public class OrderDetailsMapper {

    public static OrderDetailsDTO toDTO(OrderDetails orderDetails){

        return new OrderDetailsDTO(
                orderDetails.getId(),
                orderDetails.getUsers().getId(),
                orderDetails.getProduct().getId(),
                orderDetails.getQuantity(),
                orderDetails.getPrice(),
                orderDetails.getOrderStatus()

        );
    }

    public static OrderDetails toOrderDetails(OrderDetailsDTO orderDetailsDTO){
        OrderDetails temp = new OrderDetails();

        temp.setId(orderDetailsDTO.id());
        temp.getProduct().setId(orderDetailsDTO.ProductID());
        temp.setQuantity(orderDetailsDTO.quantity());
        temp.setPrice(orderDetailsDTO.price());
        temp.setOrderStatus(orderDetailsDTO.OrderStatus());

        return temp;
    }

    public static OrderDetailsResponseDTO toOrderDetailsResponse(OrderDetails orderDetails){

        String userName = orderDetails.getUsers().getFirstName() +
                " " +
                orderDetails.getUsers().getLastName();

        return new OrderDetailsResponseDTO(
                orderDetails.getId(),
                orderDetails.getUsers().getId(),
                userName,
                orderDetails.getProduct().getId(),
                orderDetails.getProduct().getName(),
                orderDetails.getQuantity(),
                orderDetails.getQuantity(),
                orderDetails.getOrderStatus(),
                orderDetails.getCreatedUpdateTime().getUpdateAt()
        );
    }
}
