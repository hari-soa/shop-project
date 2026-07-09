package org.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String shopName;
    private String nif;
    private String stat;

    private List<Product> products = new ArrayList<>();

    public Product[] filterProductsBy(ProductCategory category, BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> filtered = new ArrayList<>();

        for (Product product : products) {
            BigDecimal currentPrice = product.getCurrentPrice();

            boolean matchesCategory = (category == null || product.getCategory() == category);
            boolean matchesMin = (minPrice == null || currentPrice.compareTo(minPrice) >= 0);
            boolean matchesMax = (maxPrice == null || currentPrice.compareTo(maxPrice) <= 0);

            if (matchesCategory && matchesMin && matchesMax) {
                filtered.add(product);
            }
        }

        return filtered.toArray(new Product[0]);
    }


}
