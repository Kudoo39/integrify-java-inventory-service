package com.example.presentation;

import com.example.application.order.IOrderService;
import com.example.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        // created
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        try {
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}