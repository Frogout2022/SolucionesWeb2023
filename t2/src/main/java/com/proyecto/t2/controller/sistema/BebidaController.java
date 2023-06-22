package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Bebida;
import com.proyecto.t2.model.service.IBebidaService;

@Controller
@RequestMapping("intranet/bebida")
public class BebidaController {

    @Autowired
    private IBebidaService bebidaService;
    @RequestMapping("/")
    public String inicio(Model model){
        Bebida bebida=new Bebida();
        model.addAttribute("bebida", bebida);
        model.addAttribute("listaBebida", bebidaService.mostrBebidas());
        return "sistema/bebida";
    }

    @RequestMapping("/guardar")
    public String guardar(Bebida bebida){
        bebidaService.guardarBebidas(bebida);
        return "redirect:/intranet/bebida/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Bebida bebida = new Bebida();
        bebida = bebidaService.buscarBebida(id);
        model.addAttribute("bebida", bebida);
        model.addAttribute("titulo", "Modificar bebida");
        model.addAttribute("listaCategorias",bebidaService.mostrBebidas());
        return "sistema/bebida"; 
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        bebidaService.eliminarBebida(id);
        return "redirect:/intranet/bebida/";
    }

}