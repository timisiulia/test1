package com.example.test1.Models;  // Ensure this is the correct package


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;
    //add cantitate
    //update la cantitate

    public Product() {
    }

    public Product(String productName, int productPrice, int productId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
    }

}
