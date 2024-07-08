package com.example.test1.Services;


import com.example.test1.generated.rest.models.Cart;
import com.example.test1.generated.rest.models.Product;
//import com.example.test1.repositories.CartRepository;
//import com.example.test1.repositories.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private ProductRepository productRepository;

    @Getter
    private Cart cart;

    public CartService() {
        this.cart = new Cart();
        if (this.cart.getProducts() == null) {
            this.cart.setProducts(new ArrayList<>());

        }
    }

    public Product getProductByName(String productName) {
        return this.cart.getProducts().stream()
                .filter(x -> x.getProductName().contains(productName))
                .findFirst()
                .orElse(null);
    }

    public Cart addItemToCart(Product product) {
        if (this.cart.getProducts() == null) {
            this.cart.setProducts(new ArrayList<>()); // Ensure the products list is initialized
        }
        this.cart.getProducts().add(product);
        //return this.cart;
        product.setCartId(this.cart.getCartId()); // Set the cartId in product

        // Save product and cart to in-memory data structures
        // This example uses an in-memory list to store products
        // This will not persist data between application restarts
        List<Product> products = this.cart.getProducts();
        int maxId = products.stream().mapToInt(Product::getProductId).max().orElse(0);
        product.setProductId(maxId + 1);

        return this.cart;
        //daca am, dau idu
        //daca nu am , inseamna ca e cartu nou, si at fac cart nou
    }
//public Cart addItemToCart(Product product) {
//    if (this.cart.getProducts() == null) {
//        this.cart.setProducts(new ArrayList<>()); // Ensure the products list is initialized
//    }
//    this.cart.getProducts().add(product);
//    product.setCartId(this.cart.getCartId()); // Set the cartId in product
//    productRepository.save(product); // Save product
//    cartRepository.save(this.cart); // Save cart
//    return this.cart;
//}

    public Cart removeItemFromCart(String productName) {
        Product p = this.cart.getProducts().stream()
                .filter(p1 -> p1.getProductName().equals(productName))
                .findFirst()
                .orElse(null);

        if (p != null) {
            this.cart.getProducts().remove(p);
        }
        return this.cart;

    }

    public Product getProductById(int productId) {
        return cart.getProducts().stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    public Product deleteProductById(int productId) {
        Product p = this.cart.getProducts().stream()
                .filter(p1 -> p1.getProductId() == productId)
                .findFirst()
                .orElse(null);

        if (p != null) {
            this.cart.getProducts().remove(p);
        }

        return p;
    }
}


