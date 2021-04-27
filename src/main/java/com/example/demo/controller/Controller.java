package com.example.demo.controller;


import com.example.demo.modelo.Producto;
import com.example.demo.servicio.ProductoServicio;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class Controller {

    public static final Marker ERRORES = MarkerManager.getMarker("errores");

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> productos(){
        return productoServicio.encuentraTodo();
    }

    @GetMapping("/productos/encuentra")
    public Producto encuentra(@RequestParam Integer id){
        if(id < 0){
            log.error(ERRORES, "Valor invalido de busqueda: {}",id);
        }
        return productoServicio.encuentraId(id);
    }

    @DeleteMapping("/productos/elimina")
    public void elimina(@RequestParam Integer id){
        if(id < 0){
            log.error(ERRORES,"Valor invalido de busqueda: {}",id);
        }
        productoServicio.deleteId(id);
    }

    @PostMapping("/productos/agrega")
    public void agrega(@RequestBody Producto producto) {
        if (producto.getNombre().equals("")) {
            log.error(ERRORES, "Nombre invalido, no puede ser cadena vacia");

        }
        productoServicio.agrega(producto.getNombre());
    }
}
