package com.frukas.warehouse.common;

public enum OrderStatus {
    PENDING,             // Order received, not yet processed
    PROCESSING,          // Order is being prepared
    PICKED,              // Items have been picked from inventory
    PACKED,              // Items have been packed and are ready to ship
    READY_FOR_SHIPMENT,  // Ready to be handed off to carrier
    SHIPPED,             // Handed off to carrier, in transit
    DELIVERED,           // Delivered to customer
    ON_HOLD,             // Order paused due to some issue
    CANCELLED,           // Order was cancelled
    RETURN_IN_PROGRESS,  // Customer initiated return
    RETURNED,            // Return has been completed
    AWAITING_STOCK,      // Waiting for stock to arrive
    SPLIT_SHIPMENT,      // Order split into multiple shipments
    FAILED_DELIVERY;     // Delivery was attempted but failed
}
