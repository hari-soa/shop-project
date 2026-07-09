package org.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public abstract class User {
    private String id;
    private String ref;
    private String firtsName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private UserStatus status;

    public User(String id, String ref, String firtsName, String lastName, String email, String password, String phone) {
        this.id = id;
        this.ref = ref;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String id) {
        this.id = id;
    }

    public void enable() {
        this.status = UserStatus.ENABLED;
    }

    public void disable() {
        this.status = UserStatus.DISABLED;
    }}

