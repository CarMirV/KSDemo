package com.example.demo.repositorio;

import com.example.demo.modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepo extends CrudRepository<Producto, Integer> {
}
