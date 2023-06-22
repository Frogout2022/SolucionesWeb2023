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
            if(User.login_emp) return "empleado/intranet";
            if(User.login_cli) return "cliente/extranetTest"; //redirect -> ruta de GetMapping(link) - no redirect -> ubicacion html
        }else return "redirect:/login";
        return "";
    }

    @GetMapping("/extranet")
    public String extra(Model model){
        if(User.sesion && User.login_cli){
                String nom_completo = User.user.getNombre();
                String[] primer_nom = nom_completo.trim().split("\\s+");
                model.addAttribute("nombre", primer_nom[0]);
                return "cliente/extranetTest";
        }else if(User.sesion && User.login_emp){
                return "redirect:/intranet";
        }else{
                return "redirect:/login";
        }
        
    }
    
}
