package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    

    @RequestMapping("/intranet")
    public String dash(){
        return "intranet";
    }
    
}
