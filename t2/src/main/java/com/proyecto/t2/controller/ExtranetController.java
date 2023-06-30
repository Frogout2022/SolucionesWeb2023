package com.proyecto.t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/extranet")
public class ExtranetController {
    
    @RequestMapping("/")
    public String inicio_extranet(){
        return "extranet";
    }
    @RequestMapping("/carrito")
    public String extranet_carrito(){
        return "extranet/extranet_carrito";
    }
    @RequestMapping("/historial")
    public String extranet_historial(){
        return "extranet/extranet_historial";
    }
    @RequestMapping("/notificaciones")
    public String extranet_notificaciones(){
        return "extranet/extranet_notificaciones";
    }
    @RequestMapping("/reclamos")
    public String extranet_reclamos(){
        return "extranet/extranet_reclamos";
    }
    @RequestMapping("/actualizar")
    public String extranet_actu_datos(){
        return "extranet/extranet_actu_datos";
    }
}
