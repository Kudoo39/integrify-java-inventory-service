package com.example.application.order;

import com.example.application.dtos.OrderMapper;
import com.example.application.dtos.StockMapper;
import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;
import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import com.example.presentation.customException.OutOfStock;
import com.example.presentation.customException.ResourceNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderItemRepo orderItemRepo;
    @Autowired
    private IOrderRepo orderRepo;

    @Autowired
    private IStockRepo stockRepo;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderReadDto> getAllOrders() {
        List<Order> orders = orderRepo.getAllOrders();
        return orders.stream()
                .map(orderMapper::toOrderRead)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderReadDto createOrder(OrderCreateDto orderDto) {
        for (OrderItemCreateDto item : orderDto.getOrderItems()) {
            Stock stock = stockRepo.getStockById(item.getProductId());
            if (stock == null) {
                throw new ResourceNotFound("Product not found with id: " + item.getProductId());
            }
            if (stock.getQuantity() < item.getQuantity()) {
                throw new OutOfStock("Insufficient stock for product id: " + item.getProductId());
            }
            stock.setQuantity(stock.getQuantity() - item.getQuantity());
            stockRepo.updateStock(stock);
        }

        Order order = orderMapper.toOrder(orderDto);

        if (order.getOrderDate() == null || order.getStatus() == null || order.getSupplier() == null) {
            throw new IllegalArgumentException("Order date, status, and supplier ID must not be null");
        }

        Order savedOrder = orderRepo.createOrder(order);

        return orderMapper.toOrderRead(savedOrder);
    }

    @Override
    public OrderReadDto getOrderById(UUID id) {
        Order order = orderRepo.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        return orderMapper.toOrderRead(order);
    }

    @Override
    public OrderReadDto updateOrder(UUID id, OrderUpdateDto orderDto) {
        Order existingOrder = orderRepo.getOrderById(id);
        if (existingOrder == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        orderMapper.updateOrderFromDto(orderDto, existingOrder);
        Order savedOrder = orderRepo.updateOrder(existingOrder);
        return orderMapper.toOrderRead(savedOrder);
    }

    @Override
    public void deleteOrder(UUID id) {
        Order order = orderRepo.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        orderRepo.deleteOrder(id);
    }
}
