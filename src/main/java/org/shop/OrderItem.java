package org.shop;

import lombok.Getter;

import java.math.BigDecimal;

@Getter

public class OrderItem {
    private String id;
    private int quantity;
    private Product product;


    public OrderItem(String id, int quantity, Product product) {
        this.quantity = quantity;
        this.id = id;
        this.product = product;
    }

    public BigDecimal getTotalItemPrice() {
        if (product == null) {
            return BigDecimal.ZERO;
        }
        return product.getCurrentPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
