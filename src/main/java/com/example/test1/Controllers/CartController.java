//package com.example.test1.Controllers;
//
//import com.example.test1.Models.Cart;
//import com.example.test1.Models.Product;
//import com.example.test1.Services.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/cart")
//public class CartController {
//
//    private final CartService cartService;
//    @Autowired
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//    @GetMapping
//    public Cart getCart()
//    {
//        return this.cartService.getCart();
//    }
//
//
//    @PostMapping("/add-item")
//    public Cart addItemToCart(@RequestBody Product product)
//    {
//        return this.cartService.addItemToCart(product);
//    }
//
//
//    @GetMapping("/get-item-by-name")
//    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
//        Product product = cartService.getProductByName(name);
//            if (product != null) {
//                return ResponseEntity.ok(product);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//            }
//}
//
//    @DeleteMapping("/delete-item")
//    public ResponseEntity<Cart> removeItemFromCart(@RequestParam String productName) {
//        Cart updatedCart = cartService.removeItemFromCart(productName);
//        return ResponseEntity.ok(updatedCart);
//    }
//}
