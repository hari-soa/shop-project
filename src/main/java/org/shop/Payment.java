package org.shop;

import lombok.Getter;

import java.math.BigDecimal;

@Getter

public class Payment {
    private String id;
    private BigDecimal amountPaid;
    private PaymentStatus status;
}
