package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.t2.model.service.sistema.interfaces.IBebidaService;
import com.proyecto.t2.model.service.sistema.interfaces.IComboService;
import com.proyecto.t2.model.service.sistema.interfaces.IMenuService;
import com.proyecto.t2.model.service.sistema.interfaces.IPiqueoService;
import com.proyecto.t2.model.service.sistema.interfaces.IPolloService;
import com.proyecto.t2.model.entidad.Combo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





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
    public String inicio(Combo combo, Model model,RedirectAttributes flash){
       
        //LISTAR EN COMBOBOX DEL FORM
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        model.addAttribute("listaMenu", iMenuService.mostrarMenus());
        model.addAttribute("listaPiqueo", iPiqueoService.mostrarPiqueos());
        model.addAttribute("listaPollo", iPolloService.mostrarPollos());
        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCombo", comboService.mostrarCombos());

    
        return "sistema/combo";
    
        
    }

    @PostMapping("/guardar")
    public String guardar(Combo combo,RedirectAttributes flash) {
        if(combo.getBebida().getId()== null) combo.setBebida(null);
        if(combo.getMenu().getId()== null) combo.setMenu(null);
        if(combo.getPiqueo().getId()== null) combo.setPiqueo(null);
        if(combo.getPollo().getId()== null) combo.setPollo(null);
        String rpt = "Se añádio el combo: "+combo.getNombre();
        flash.addFlashAttribute("mensaje", rpt);
        
        comboService.guardarCombos(combo);
        return "redirect:/intranet/combo/";
    }
    @PostMapping("/editar")
    public String editar(Combo combo,RedirectAttributes flash) {
        if(combo.getBebida().getId()== null) combo.setBebida(null);
        if(combo.getMenu().getId()== null) combo.setMenu(null);
        if(combo.getPiqueo().getId()== null) combo.setPiqueo(null);
        if(combo.getPollo().getId()== null) combo.setPollo(null);
        String rpt = "Se actualizó el combo: "+combo.getNombre();
        flash.addFlashAttribute("mensaje", rpt);
        
        comboService.guardarCombos(combo);
        return "redirect:/intranet/combo/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash ){
         String rpt = "Se eliminó el combo con id: "+id;
        flash.addFlashAttribute("mensaje", rpt);
        comboService.eliminarCombo(id);
        return "redirect:/intranet/combo/";
    }


}
