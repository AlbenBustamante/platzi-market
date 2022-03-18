package com.alnicode.platzi.market.persistence;

import com.alnicode.platzi.market.persistence.crud.ProductoCrudRepository;
import com.alnicode.platzi.market.persistence.entity.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (ArrayList<Producto>) this.productoCrudRepository.findAll();
    }
}
