package com.alnicode.platzi.market.web.controller;

import com.alnicode.platzi.market.domain.Product;
import com.alnicode.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<Product> getAll() {
        return this.productService.getAll();
    }

    public List<Product> getByCategory(int categoryId) {
        return this.productService.getByCategory(categoryId);
    }

    public Optional<Product> getProduct(int productId) {
        return this.productService.getProduct(productId);
    }

    public Product save(Product product) {
        return this.productService.save(product);
    }

    public boolean delete(int productId) {
        return this.productService.delete(productId);
    }
}
