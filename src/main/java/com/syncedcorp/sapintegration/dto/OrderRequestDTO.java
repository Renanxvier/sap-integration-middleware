package com.syncedcorp.sapintegration.dto;

import java.util.List;

public class OrderRequestDTO {
    private String customerName;
    private String customerEmail;
    private List<OrderItemRequestDTO> items;

    // Getters e Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public List<OrderItemRequestDTO> getItems() { return items; }
    public void setItems(List<OrderItemRequestDTO> items) { this.items = items; }
}