package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.proyecto.t2.model.entidad.Cliente;


@Controller
public class MainController {
    @RequestMapping("/")
    public String inicio(){
        return "publico/index";
    }

    @RequestMapping("/platillos")
    public String about(){
        return "publico/platillos";
    }

    @RequestMapping("/combos")
    public String products(){
        return "publico/combos";
    }

    @RequestMapping("/ubicanos")
    public String store(){
        return "publico/ubicanos";
    }

    @RequestMapping("/error_html")
    public String error(){
        return "error/error";
    }
    

    @RequestMapping("/intranet/")
    public String dash(Model model){
        return "empleado/intranet";
    }

    @GetMapping("/extranet/")
    public String extra(Model model){
        //String nom_completo = User.user.getNombre();
        //String[] primer_nom = nom_completo.trim().split("\\s+");
        //model.addAttribute("nombre", primer_nom[0]);
        return "cliente/extranet"; 
    }

    @GetMapping("/polleria/login")//vista
    public String loginSL(
        Cliente cli,@RequestParam(name = "error", required = false) String error, 
        Model model){ 
        if (error != null)  model.addAttribute("error", true);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                String authorityName = authority.getAuthority();
                if(authorityName.equals("ROL_ADMIN")) return "redirect:/intranet/";
                if (authorityName.equals("ROL_USUARIO")) return "redirect:/extranet/";
            }   
        } 
        return "PolleriaLogin";    
    }

    @GetMapping("/validacion/login")
    public String validacion(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                String authorityName = authority.getAuthority();
                if(authorityName.equals("ROL_ADMIN")) return "redirect:/intranet/";
                if (authorityName.equals("ROL_USUARIO")) return "redirect:/extranet/";
    
            }   
        } 
        return "validacion";
    }
    
    @GetMapping("/acceso-denegado")
    public String denegado(){
        return "error/acceso_denegado";
    }
    
}
