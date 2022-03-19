package com.alnicode.platzi.market.domain.service;

import com.alnicode.platzi.market.domain.Product;
import com.alnicode.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return this.productRepository.getAll();
    }

    public List<Product> getByCategory(int categoryId) {
        return this.productRepository.getByCategory(categoryId);
    }

    public Optional<Product> getProduct(int productId) {
        return this.productRepository.getProduct(productId);
    }

    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public boolean delete(int productId) {
        try {
            this.productRepository.delete(productId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
