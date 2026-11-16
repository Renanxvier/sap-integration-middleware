package com.syncedcorp.sapintegration.controller;

import com.syncedcorp.sapintegration.dto.OrderRequestDTO;
import com.syncedcorp.sapintegration.model.Order;
import com.syncedcorp.sapintegration.repository.OrderRepository;
import com.syncedcorp.sapintegration.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    // Endpoint para criar um novo pedido (POST)
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO requestDTO) {
        Order processedOrder = orderService.processNewOrder(requestDTO);
        return ResponseEntity.ok(processedOrder);
    }

    // Endpoint para listar todos os pedidos criados (GET) - Perfeito para testar no navegador!
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }
}