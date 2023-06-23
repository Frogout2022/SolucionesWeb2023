package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.service.sistema.IPolloService;
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
    @Autowired
    private IPolloService iPolloService;

    @RequestMapping("/")
    public String inicio(Combo combo, Model model){
        //LISTAR EN COMBOBOX DEL FORM
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        model.addAttribute("listaMenu", iMenuService.mostrarMenus());
        model.addAttribute("listaPiqueo", iPiqueoService.mostrarPiqueos());
        model.addAttribute("listaPollo", iPolloService.mostrarPollos());
        
       
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCombo", comboService.mostrarCombos());
        return "sistema/combo";
    }
}
