package com.alnicode.platzi.market.persistence;

import com.alnicode.platzi.market.persistence.crud.ProductoCrudRepository;
import com.alnicode.platzi.market.persistence.entity.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
