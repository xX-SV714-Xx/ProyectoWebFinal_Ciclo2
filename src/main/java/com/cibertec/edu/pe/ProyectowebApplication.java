package com.cibertec.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cibertec.edu.pe")
public class ProyectowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectowebApplication.class, args);
	}

}
