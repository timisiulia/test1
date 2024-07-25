package com.example.test1.repositories;

import com.example.test1.Models.Cart;
import com.example.test1.generated.rest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);
    Product findByProductNameAndCart(String productName, Cart cart);
}
