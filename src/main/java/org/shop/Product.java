package org.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor

public class Product {
    private String id;
    private String name;
    private String description;
    private Instant createdAt;
    private ProductCategory category;

    private List<PriceHistory> priceHistories = new ArrayList<>();

    public Product(String id, String name, String description, ProductCategory Category, ArrayList<PriceHistory> priceHistories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = Category;
    }

    public BigDecimal getCurrentPrice() {
        return getPriceAt(Instant.now());
    }

    public BigDecimal getPriceAt(Instant t) {
        PriceHistory mostRecentValid = null;
        for (PriceHistory history : priceHistories) {
            if (!history.getEffectiveFrom().isAfter(t)) {
                if (mostRecentValid == null || history.getEffectiveFrom().isAfter(mostRecentValid.getEffectiveFrom())) {
                    mostRecentValid = history;
                }
            }
        }

        return mostRecentValid != null ? mostRecentValid.getPrice() : BigDecimal.ZERO;
    }

}
