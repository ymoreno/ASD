package com.grupoasd.activosfijos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grupoasd.activosfijos.services.ActivosService;
import com.grupoasd.activosfijos.services.DefaultActivosService;

@SpringBootApplication
public class ActivosfijosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivosfijosApplication.class, args);
	}
	
    @Bean
    public ActivosService transferService() {
        return new DefaultActivosService();
    }

}
