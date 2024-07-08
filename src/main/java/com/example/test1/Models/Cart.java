package com.example.test1.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    // Add other columns here
    @Column(name = "user_id")
    private int userId;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "status")
    private String status;
    //eunm in Db, enumerate type
    //fa endponynt pt calcul prod din cos

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Product> products = new ArrayList<>();

    public Cart() {
    }

    public Cart(int userId, double totalPrice, String status, List<Product> products) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.products = products;
    }

}
