package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Cliente;


@Controller
public class MainController {
    @RequestMapping("/")
    public String inicio(){
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/products")
    public String products(){
        return "products";
    }

    @RequestMapping("/store")
    public String store(){
        return "store";
    }

    @RequestMapping("/error_html")
    public String error(){
        return "error/error";
    }
    /* 
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    */
    

    @RequestMapping("/intranet")
    public String dash(){
        return "intranet";
    }
    
}
