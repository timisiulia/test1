package com.example.test1.Services;


import com.example.test1.generated.rest.models.Cart;
import com.example.test1.generated.rest.models.Product;
import com.example.test1.generated.rest.models.Status;
import com.example.test1.repositories.CartRepository;
import com.example.test1.repositories.ProductRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCart(int cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        return cart.orElse(null);
    }

    public Cart addNewItemToCart(int cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            product.setCart(cart);
            cart.getProducts().add(product);
            cart.setTotalPrice(cart.getTotalPrice() + product.getProductPrice() * product.getQuantity());
            productRepository.save(product);
            cartRepository.save(cart);
        }
        return cart;
    }

    public Product getItemByNameNew(String name) {
        return productRepository.findByProductName(name);
    }

    public Cart removeItem(String productName, int cartId) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            List<Product> products = cart.getProducts();
            products.removeIf(product -> product.getProductName().equals(productName));
            cartRepository.save(cart);
        }
        return cart;
    }

    public Cart closeCart(int cartId) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            cart.setStatus(Cart.StatusEnum.CLOSE);
            cartRepository.save(cart);
        }
        return cart;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
