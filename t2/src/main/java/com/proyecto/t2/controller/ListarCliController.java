package com.proyecto.t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.service.IClienteService;

@Controller
@RequestMapping("intranet/cliente")
public class ListarCliController {
    @Autowired
    private IClienteService iClienteService;
    @RequestMapping("/listar_cli")
    public String inicio(Model model){
        model.addAttribute("listaClientes", iClienteService.listarClientes());
        return "cliente/listar_cli";
    }

    
}
