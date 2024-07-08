//package com.example.test1.Services;
//
//import com.example.test1.generated.rest.models.Product;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//
//public class ProductService {
//
//    private final List<Product> productsList = new ArrayList<>();
//
//    public List<Product> getAllProducts() {
//        return productsList;
//    }
//
//    public Product getProductById(int productId) {
//        return productsList.stream()
//                .filter(product -> product.getProductId()== productId)
//                .findFirst()
//                .orElse(null);
//    }
//
//    public boolean deleteProductById(int productId) {
//        return productsList.removeIf(product -> product.getProductId() == productId);
//    }
//}
