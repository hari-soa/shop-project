package org.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@AllArgsConstructor

public class PriceHistory {
    private String id;
    private BigDecimal price;
    private Instant effectiveFrom;

    public PriceHistory(int i, BigDecimal price, Instant parse) {
        this.id = Integer.toString(i);
        this.price = price;
        this.effectiveFrom = parse;
    }
}
