package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.entidad.Usuario;

@Controller

public class LoginController {
    @GetMapping("/login2")
    public String mostrarFormularioLogin(Usuario perro) {
        return "login2";
    }

    @PostMapping("/login2")
    public String iniciarSesion(Usuario user, BindingResult result, Model model) {
        
        if(result.hasErrors()){
            model.addAttribute("error", "Error login2");
            return "error/error";

        }
        //user.setCorre("ADIOS");

        


        if (user.getCorre().equals("usuario@example.com") && user.getClaves().equals("GG")) {
            // Lógica para iniciar sesión exitosamente
            return "redirect:/";
        } else {
            
            model.addAttribute("error", "Credenciales incorrectas");
            return "/login2";
        }
        
    }
}
