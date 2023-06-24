package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Piqueo;
import com.proyecto.t2.model.entidad.User;
import com.proyecto.t2.model.service.sistema.IPiqueoService;

@Controller
@RequestMapping("intranet/piqueo")
public class PiqueoController {
    
    @Autowired
    private IPiqueoService piqueoService;
    @RequestMapping("/")
    public String inicio(Model model){
        if(User.sesion && User.login_emp){//validar sesion del admin
            Piqueo piqueo=new Piqueo();
            model.addAttribute("piqueo", piqueo);
            model.addAttribute("titulo", "Registrar nuevo piqueo");
            model.addAttribute("listaPiqueo", piqueoService.mostrarPiqueos());
            return "sistema/piqueo";
        }
        return "redirect:/login";
        
    }

    @RequestMapping("/guardar")
    public String guardar(Piqueo piqueo){
        piqueoService.guardarPiqueos(piqueo);
        return "redirect:/intranet/piqueo/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        if(User.sesion && User.login_emp){ //validar la sesion del admin
            Piqueo Piqueo = new Piqueo();
            Piqueo = piqueoService.buscarPiqueo(id);
            model.addAttribute("piqueo", Piqueo);
            model.addAttribute("titulo", "Modificar piqueo");
            model.addAttribute("listaPiqueo", piqueoService.mostrarPiqueos());
            return "sistema/piqueo"; 
        }
        return "redirect:/login";

        
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        piqueoService.eliminarPiqueo(id);
        return "redirect:/intranet/piqueo/";
    }
}
