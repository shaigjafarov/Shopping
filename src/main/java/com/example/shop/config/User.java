package com.example.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class User {

    @Value("${example.name}")
    private String name;

    @Value("${example.surname}")
    private  String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
