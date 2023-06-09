package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.entidad.User;


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
    public String dash(Model model){
        if(User.sesion) {
            if(User.login_emp){
                //String nom = User.user.getNombre();
                //model.addAttribute("nombre", nom);
                return "intranet";
            }
            if(User.login_cli){
                return "cliente/extranet";
            }
          
        }else return "redirect:/cliente/login";

        return "";
    }

    @GetMapping("/extranet")
    public String extra(Model model){
        if(User.sesion)
            if(User.login_emp) return "redirect:/cliente/extranet";
        
        return "redirect:/cliente/login";

    }
    
}
