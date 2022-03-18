package com.alnicode.platzi.market.persistence.crud;

import com.alnicode.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*@Query(value = "SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true)
    * List<Producto> getByCategoria(int idCategoria);
    * */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
}
