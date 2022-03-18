package com.alnicode.platzi.market.persistence;

import com.alnicode.platzi.market.persistence.crud.ProductoCrudRepository;
import com.alnicode.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (ArrayList<Producto>) this.productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return this.productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock) {
        return this.productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return this.productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return this.productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        this.productoCrudRepository.deleteById(idProducto);
    }
}
