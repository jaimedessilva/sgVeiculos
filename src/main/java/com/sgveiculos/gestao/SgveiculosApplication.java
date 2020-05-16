package com.sgveiculos.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class SgveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgveiculosApplication.class, args);
	}

}
