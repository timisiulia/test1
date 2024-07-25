package com.example.test1.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private  Status status;
    //eunm in Db, enumerate type
    //fa endponynt pt calcul prod din cos

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Product> products = new ArrayList<>();

}
