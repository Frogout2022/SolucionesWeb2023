package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Pollo;
import com.proyecto.t2.model.service.sistema.interfaces.IPolloService;

@Controller
@RequestMapping("intranet/pollo")
public class PolloController {
    
    @Autowired
    private IPolloService polloService;
    @RequestMapping("/")
    public String inicio(Model model){
        Pollo pollo=new Pollo();
        model.addAttribute("pollo", pollo);
        model.addAttribute("listaPollo", polloService.mostrarPollos());
        return "sistema/pollo";
    }

    @RequestMapping("/guardar")
    public String guardar(Pollo pollo){
        polloService.guardarPollos(pollo);
        return "redirect:/intranet/pollo/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
       
        Pollo pollo = new Pollo();
        pollo = polloService.buscarPollo(id);
        model.addAttribute("pollo", pollo);
        model.addAttribute("titulo", "Modificar pollo");
        model.addAttribute("listaCategorias", polloService.mostrarPollos());
        return "sistema/pollo"; 
       
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        polloService.eliminarPollo(id);
        return "redirect:/intranet/pollo/";
    }
}
