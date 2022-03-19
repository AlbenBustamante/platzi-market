package com.alnicode.platzi.market.web.controller;

import com.alnicode.platzi.market.domain.Product;
import com.alnicode.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/category/{id}")
    public List<Product> getByCategory(@PathVariable("id") int categoryId) {
        return this.productService.getByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId) {
        return this.productService.getProduct(productId);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return this.productService.delete(productId);
    }
}
