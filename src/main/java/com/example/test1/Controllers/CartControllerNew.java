package com.example.test1.Controllers;

import com.example.test1.Services.CartService;
import com.example.test1.generated.rest.api.CartApi;
import com.example.test1.generated.rest.models.Cart;
import com.example.test1.generated.rest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@CrossOrigin

public class CartControllerNew implements  CartApi {

    @Autowired
    private final CartService cartService;

    public CartControllerNew(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CartApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok(cartService.getCart());
    }


    @Override
    public ResponseEntity<Cart> addNewItemToCart(Product product) {
        Cart updatedCart = cartService.addItemToCart(product);
        return ResponseEntity.ok(updatedCart);
    }

    @Override
    public ResponseEntity<Product> getItemByNameNew(String name) {
        Product product= cartService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(404).body(null);
        }
        //return CartApi.super.getItemByNameNew(name);
    }

    @Override
    public ResponseEntity<Cart> removedItem(String productName) {
        Cart updatedCart = cartService.removeItemFromCart(productName);
        return ResponseEntity.ok(updatedCart);
        //return CartApi.super.removedItem(productName);
    }
}
