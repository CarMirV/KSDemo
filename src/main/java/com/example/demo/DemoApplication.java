package com.example.demo;

import com.example.demo.modelo.Producto;
import com.example.demo.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	@Autowired
	ProductoServicio productoServicio;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}


	@Override
	public void run(ApplicationArguments args) throws Exception{
		System.out.println("Aplicacion corriendo");
	}
}
