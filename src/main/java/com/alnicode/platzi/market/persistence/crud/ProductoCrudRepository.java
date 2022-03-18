package com.alnicode.platzi.market.persistence.crud;

import com.alnicode.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
