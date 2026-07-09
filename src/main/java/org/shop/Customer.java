package org.shop;

import java.util.ArrayList;
import java.util.List;


public class Customer extends User {
    private String deliveryAddress;

    private List<Order> orders = new ArrayList<>();

    public Customer(String id, String ref, String firtsName, String lastName, String email, String password, String phone) {
        super(id, ref, firtsName, lastName, email, password, phone);
    }

    public Order[] getRecentOrders() {
        return orders.toArray(new Order[0]);
    }
}
