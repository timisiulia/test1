package com.example.test1.Controllers;

import com.example.test1.Services.CartService;
import com.example.test1.generated.rest.api.ProductApi;
import com.example.test1.generated.rest.models.Product;  // Ensure this is the correct import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductControllerNew implements ProductApi {

    @Autowired
    // private final ProductService productService;
    private final CartService cartService;

    public ProductControllerNew(CartService cartService) {
        this.cartService = cartService;
    }


//    public ProductControllerNew(ProductService productService) {
//        this.productService = productService;
//    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ProductApi.super.getRequest();
    }


    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = cartService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
        Product product = cartService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Product> deleteProductById(@RequestParam("productId") Integer productId) {
        cartService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

}
