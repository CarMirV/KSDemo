package com.example.demo.repositorio;

import com.example.demo.modelo.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductoRepo extends CrudRepository<Producto, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT P FROM productos p")
    List<Producto> retornaTodo();

    @Transactional
    @Query(value = "SELECT P FROM productos p WHERE p.id = id")
    Producto encuentraId(Integer id);

    @Modifying
    @Query(value = "INSERT INTO productos(nombre) VALUES(nombre)")
    void agregaP(String nombre);

}
