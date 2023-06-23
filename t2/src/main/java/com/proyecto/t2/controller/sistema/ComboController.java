package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.IBebidaService;
import com.proyecto.t2.model.service.IMenuService;
import com.proyecto.t2.model.service.sistema.IComboService;
import com.proyecto.t2.model.service.sistema.IPiqueoService;

@Controller
@RequestMapping("intranet/combo")
public class ComboController {

    @Autowired
    private IBebidaService bebidaService;
    @Autowired
    private IComboService comboService;
    @Autowired
    private IMenuService iMenuService;
    @Autowired
    private IPiqueoService iPiqueoService;

    @RequestMapping("/")
    public String inicio(Combo combo, Model model){
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        model.addAttribute("listaMenu", iMenuService.mostrarMenus());
        model.addAttribute("listaPiqueo", iPiqueoService.mostrarPiqueos());
        
       

        model.addAttribute("listaCombo", comboService.mostrarCombos());
        return "sistema/combo";
    }
}
