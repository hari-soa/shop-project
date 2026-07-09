package org.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter

public class Order {
    private String id;
    private Instant createdAt ;
    private Instant updatedAt ;
    private Customer customer;

    private List<OrderItem> items = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();

    public Order(String id, Instant parse, Instant parse1, Customer customer, ArrayList<OrderItem> items) {
        this.id = id;
        this.createdAt = parse;
        this.updatedAt = parse1;
        this.customer = customer;
        this.items = items;
    }

    public OrderItem addItem(OrderItem toAdd) {
        if (toAdd != null) {
            this.items.add(toAdd);
            this.updatedAt = Instant.now();
        }
        return toAdd;
    }

    public OrderItem removeItem(OrderItem item) {
        if (this.items.remove(item)) {
            this.updatedAt = Instant.now();
            return item;
        }
        return null;
    }

    public BigDecimal getTotalCost() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            total = total.add(item.getTotalItemPrice());
        }
        return total;
    }

    public boolean isPaid() {
        BigDecimal totalPaid = BigDecimal.ZERO;
        for (Payment payment : payments) {
            if (payment.getStatus() == PaymentStatus.DONE) {
                totalPaid = totalPaid.add(payment.getAmountPaid());
            }
        }
        return totalPaid.compareTo(this.getTotalCost()) >= 0;
    }
}
