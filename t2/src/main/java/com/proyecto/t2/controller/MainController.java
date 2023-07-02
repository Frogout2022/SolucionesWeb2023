package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/polleria/login")
    public String loginSL(Cliente cli){ //vista
        return "PolleriaLogin";
    }
    @GetMapping("/validacion/login")
    public String validacion(){

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    // Verificar si el usuario está autenticado
    if (authentication != null && authentication.isAuthenticated()) {
    // Obtener la lista de autoridades del usuario
    List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

    // Recorrer las autoridades y realizar las acciones necesarias
    for (GrantedAuthority authority : authorities) {
        String authorityName = authority.getAuthority();
        // Aquí puedes hacer lo que necesites con la autoridad, como verificar permisos, roles, etc.
        if(authorityName.equals("ROL_ADMIN")) return "redirect:/intranet/";
        if (authorityName.equals("ROL_USUARIO")) return "redirect:/extranet/";
        System.out.println("Autoridad del usuario: " + authorityName);
    }   
    } else {
    // El usuario no está autenticado, realizar acciones correspondientes
    System.out.println("Usuario no autenticado");   
    }
    
        return "validacion";
    }
    @GetMapping("/acceso-denegado")
    public String denegado(){
        return "error/acceso_denegado";
    }
    
    
}
