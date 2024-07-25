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

import java.util.List;
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
    public ResponseEntity<Cart> getCart(@RequestParam("cartId") Integer cartId) {
        Cart cart = cartService.getCart(cartId);
        return ResponseEntity.ok(cart);
    }

    @Override
    public ResponseEntity<Cart> addNewItemToCart(@RequestParam("cartId") Integer cartId, @RequestBody Product product) {
        Cart cart = cartService.addNewItemToCart(cartId, product);
        return ResponseEntity.ok(cart);
    }

    @Override
    public ResponseEntity<Product> getItemByNameNew(@RequestParam("name") String name) {
        Product product = cartService.getItemByNameNew(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Cart> removeItem(@RequestParam("productName") String productName, @RequestParam("cartId") Integer cartId) {
        Cart cart = cartService.removeItem(productName, cartId);
        return ResponseEntity.ok(cart);
    }

    @Override
    public ResponseEntity<Cart> closeCart(@RequestParam("cartId") Integer cartId) {
        Cart cart = cartService.closeCart(cartId);
        return ResponseEntity.ok(cart);
    }
}
