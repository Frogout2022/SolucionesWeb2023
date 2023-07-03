package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.t2.model.entidad.Carrito;
import com.proyecto.t2.model.service.sistema.ICarritoService;

@Controller
@RequestMapping("/extranet")
public class ExtranetController {
    @Autowired
    ICarritoService iCarritoService;

    @RequestMapping("/")
    public String inicio_extranet(){
        return "cliente/extranet";
    }
    @RequestMapping("/carrito")
    public String extranet_carrito(Model model){
        
        Carrito carrito = new Carrito();
        model.addAttribute("carr", carrito);
        List<Carrito> lista = iCarritoService.listarCarrito();
        model.addAttribute("listaProductos", lista);
        return "cliente/extranet_carrito";
        //return "test";
    }
    @RequestMapping("/historial")
    public String extranet_historial(){
        return "cliente/extranet_historial";
    }
    @RequestMapping("/notificaciones")
    public String extranet_notificaciones(){
        return "cliente/extranet_notificaciones";
    }
    @RequestMapping("/reclamos")
    public String extranet_reclamos(){
        return "cliente/extranet_reclamos";
    }
    @RequestMapping("/actualizar")
    public String extranet_actu_datos(){
        return "cliente/extranet_actu_datos";
    }
    @RequestMapping("/boletas")
    public String extranet_boleta(){
        return "cliente/extranet_boleta";
    }
}
