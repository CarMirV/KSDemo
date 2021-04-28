package com.example.demo.servicio;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ProductoServicio {
    @Autowired
    private ProductoRepo productoRepo;

    private String nombre;

    /**
     *
     * @return Retorna una lista con todos los productos en la BD.
     */
    public List<Producto> encuentraTodo(){
        return (List<Producto>) productoRepo.findAll();
    }

    /**
     *
     * @param id Id del producto a buscar
     * @return Retorna el Producto encontrado con el id especificado
     */
    public Producto encuentraId(Integer id){
        return productoRepo.findById(id).orElse(new Producto());
    }

    /**
     *
     * @param id Id del producto a eliminar
     */
    public void deleteId(Integer id){
        productoRepo.deleteById(id);
        System.out.printf("El producto con id %d ha sido eliminado con exito\n",id);
    }

    /**
     *
     * @param nombre Nombre del producto a agregar
     */
    public void agrega(String nombre){
        productoRepo.save(new Producto(nombre));
        System.out.printf("El producto %s ha sido agregado a la BD con exito\n", nombre);
    }



}
