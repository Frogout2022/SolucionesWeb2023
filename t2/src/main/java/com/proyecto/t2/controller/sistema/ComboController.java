package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.service.sistema.IPolloService;
import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.IBebidaService;
import com.proyecto.t2.model.service.IMenuService;
import com.proyecto.t2.model.service.sistema.IComboService;
import com.proyecto.t2.model.service.sistema.IPiqueoService;

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

    @PostMapping("/guardar")
    public String guardar(Combo combo) {
        if(combo.getBebida().getId()== null) combo.setBebida(null);
        if(combo.getMenu().getId()== null) combo.setMenu(null);
        if(combo.getPiqueo().getId()== null) combo.setPiqueo(null);
        if(combo.getPollo().getId()== null) combo.setPollo(null);

        
        
        comboService.guardarCombos(combo);
        return "redirect:/intranet/combo/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Combo combo = new Combo();
        
        combo = comboService.buscarCombo(id);
        model.addAttribute("combo", combo);
        model.addAttribute("titulo", "Modificar combo");
        model.addAttribute("listaCombos", comboService.mostrarCombos());
        return "sistema/combo"; 
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        comboService.eliminarCombo(id);
        return "redirect:/intranet/combo/";
    }


}
