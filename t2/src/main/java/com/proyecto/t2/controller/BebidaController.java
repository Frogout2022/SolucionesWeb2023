package com.proyecto.t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Bebida;
import com.proyecto.t2.model.service.IBebidaService;

@Controller
@RequestMapping("/bebida")
public class BebidaController {

    @Autowired
    private IBebidaService bebidaService;
    @RequestMapping("/")
    public String inicio(Model model){
        Bebida bebida=new Bebida();
        model.addAttribute("bebida", bebida);
        return "bebida/inicio";
    }

    @RequestMapping("/guardar")
    public String guardar(Bebida bebida){
        bebidaService.guardarBebidas(bebida);
        return "redirect:/bebida/";
    }
}