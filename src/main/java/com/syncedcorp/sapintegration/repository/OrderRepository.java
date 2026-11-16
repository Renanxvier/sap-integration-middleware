package com.syncedcorp.sapintegration.repository;

import com.syncedcorp.sapintegration.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // O Spring Data JPA já cria métodos prontos como save(), findById(), findAll(), etc.
}