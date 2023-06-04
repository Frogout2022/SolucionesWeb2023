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
    @RequestMapping("/registrarse")
    public String registrarse(){
        return "registrarse";
    }
}
