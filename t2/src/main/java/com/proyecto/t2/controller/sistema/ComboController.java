package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.IBebidaService;

@Controller
@RequestMapping("intranet/combo")
public class ComboController {

    @Autowired
    private IBebidaService bebidaService;

    @RequestMapping("/")
    public String inicio(Combo combo, Model model){
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        return "sistema/combo";
    }
}
