package com.syncedcorp.sapintegration.dto;

import java.math.BigDecimal;

public class OrderItemRequestDTO {
    private String productCode;
    private Integer quantity;
    private BigDecimal unitPrice;

    // Getters e Setters
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
}