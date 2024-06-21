package com.example.presentation;

import com.example.application.orderItem.IOrderItemService;
import com.example.domain.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orderitems")
public class OrderItemController {
    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        // created
        return ResponseEntity.ok(createdOrderItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable UUID id) {
        try {
            OrderItem orderItem = orderItemService.getOrderItemById(id);
            return ResponseEntity.ok(orderItem);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrder(@PathVariable UUID id, @RequestBody OrderItem orderItem) {
        try {
            OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, orderItem);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable UUID id) {
        try {
            orderItemService.deleteOrderItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
