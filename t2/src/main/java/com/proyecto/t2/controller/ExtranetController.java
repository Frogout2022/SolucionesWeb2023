package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/extranet")
public class ExtranetController {
    
    @RequestMapping("/")
    public String inicio_extranet(){
        return "cliente/extranet";
    }
    @RequestMapping("/carrito")
    public String extranet_carrito(){
        return "cliente/extranet_carrito";
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
