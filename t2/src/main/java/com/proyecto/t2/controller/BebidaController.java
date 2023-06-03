package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bebida")
public class BebidaController {

    @RequestMapping("/")
    public String inicio(){
        return "bebida/inicio";
    }
}
