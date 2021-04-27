package com.example.demo.servicio;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepo productoRepo;

    public List<Producto> encuentraTodo(){
        return (List<Producto>) productoRepo.findAll();
    }

    public Producto encuentraId(Integer id){
        return productoRepo.findById(id).orElse(new Producto());
    }

    public void deleteId(Integer id){
        productoRepo.deleteById(id);
        System.out.printf("El producto con id %d ha sido eliminado con exito\n",id);
    }

    public void agrega(String nombre){
        productoRepo.save(new Producto(nombre));
        System.out.printf("El producto %s ha sido agregado a la BD con exito\n", nombre);
    }



}
