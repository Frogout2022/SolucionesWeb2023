package com.proyecto.t2.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//maejo de erroes
@SpringBootApplication
public class Polleria extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Polleria.class, args);
    }

    @Bean
    public ErrorController errorController() {
        return new ErrorController() {
            
        };
    }
}
