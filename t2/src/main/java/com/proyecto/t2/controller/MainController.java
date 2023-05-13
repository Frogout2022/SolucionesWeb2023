package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/dashboard")
    public String dash(){
        // @RequestParam(name = "usuario", required = false, defaultValue = "s") String usuario, 
        // @RequestParam(name = "contra",required = false, defaultValue = "1") String contra,
        // Model model){
        
        // if(usuario=="admin"){
        //     return "intranet";
        // }else{
        //     return "login";
        // }
        return "intranet";
    }
}
