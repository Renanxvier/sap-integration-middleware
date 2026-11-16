package com.syncedcorp.sapintegration.service;

import com.syncedcorp.sapintegration.dto.OrderItemRequestDTO;
import com.syncedcorp.sapintegration.dto.OrderRequestDTO;
import com.syncedcorp.sapintegration.model.Order;
import com.syncedcorp.sapintegration.model.OrderItem;
import com.syncedcorp.sapintegration.model.OrderStatus;
import com.syncedcorp.sapintegration.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order processNewOrder(OrderRequestDTO requestDTO) {
        // 1. Cria a entidade Order com base no DTO
        Order order = new Order();
        order.setCustomerName(requestDTO.getCustomerName());
        order.setCustomerEmail(requestDTO.getCustomerEmail());
        order.setStatus(OrderStatus.PENDING);

        // 2. Adiciona os itens ao pedido
        for (OrderItemRequestDTO itemDto : requestDTO.getItems()) {
            OrderItem item = new OrderItem(
                itemDto.getProductCode(),
                itemDto.getQuantity(),
                itemDto.getUnitPrice()
            );
            order.addItem(item);
        }

        // 3. Salva inicialmente como PENDING no banco local
        Order savedOrder = orderRepository.save(order);

        // 4. SIMULAÇÃO DA INTEGRAÇÃO COM O SAP
        try {
            // Aqui simulamos a chamada HTTP para o ERP SAP
            boolean sapSuccess = callSapSystemSimulation(savedOrder);

            if (sapSuccess) {
                savedOrder.setStatus(OrderStatus.SYNCED_WITH_SAP);
                savedOrder.setSapOrderId("SAP-ORD-" + (100000 + savedOrder.getId()));
            } else {
                savedOrder.setStatus(OrderStatus.FAILED);
            }
        } catch (Exception e) {
            savedOrder.setStatus(OrderStatus.FAILED);
        }

        // 5. Atualiza o status final no banco de dados local
        return orderRepository.save(savedOrder);
    }

    private boolean callSapSystemSimulation(Order order) {
        // Simulando um delay de rede de integração (ex: chamando o ERP)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Retorna true simulando que o SAP aceitou o pedido com sucesso
        return true; 
    }
}