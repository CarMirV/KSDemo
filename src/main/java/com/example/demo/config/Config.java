package com.example.demo.config;


import com.example.demo.repositorio.ProductoRepo;
import com.example.demo.servicio.ProductoServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("ProductoXbox")
    public ProductoServicio productoServicioXbox(ProductoRepo productoRepo){
        ProductoServicio productoServicio = new ProductoServicio();
        productoServicio.setProductoRepo(productoRepo);
        productoServicio.setNombre("Xbox");
        return productoServicio;
    }

    @Bean("Producto")
    public ProductoServicio productoServicio(ProductoRepo productoRepo){
        ProductoServicio productoServicio = new ProductoServicio();
        productoServicio.setProductoRepo(productoRepo);
        return productoServicio;
    }

}
