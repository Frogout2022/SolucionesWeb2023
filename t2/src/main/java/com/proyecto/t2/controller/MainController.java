package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping({"/", "/index.html"})
    public String inicio(){
        return "index";
    }

    @RequestMapping("/about.html")
    public String about(){
        return "about";
    }

    @RequestMapping("/products.html")
    public String products(){
        return "products";
    }

    @RequestMapping("/store.html")
    public String store(){
        return "store";
    }

    
}
