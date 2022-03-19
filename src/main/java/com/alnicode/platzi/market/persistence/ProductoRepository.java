package com.alnicode.platzi.market.persistence;

import com.alnicode.platzi.market.domain.Product;
import com.alnicode.platzi.market.domain.repository.ProductRepository;
import com.alnicode.platzi.market.persistence.crud.ProductoCrudRepository;
import com.alnicode.platzi.market.persistence.entity.Producto;
import com.alnicode.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    //contenedor de control de version
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) this.productoCrudRepository.findAll();
        return this.mapper.toProducts(productos);
    }

    @Override
    public List<Product> getByCategory(int categoryId) {
        List<Producto> productos = this.productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return this.mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = this.productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(products -> this.mapper.toProducts(products));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return this.productoCrudRepository.findById(productId).map(producto -> this.mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = this.mapper.toProducto(product);
        return this.mapper.toProduct(this.productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        this.productoCrudRepository.deleteById(productId);
    }
}
