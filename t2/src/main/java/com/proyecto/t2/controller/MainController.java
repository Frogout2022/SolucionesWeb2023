package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/Proyecto")
public class MainController {
    @RequestMapping("/")
    public String inicio(){
        return "index";
    }
//prueba de comentario
    
}
