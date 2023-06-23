package com.proyecto.t2.controller.sistema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.IBebidaService;
import com.proyecto.t2.model.service.sistema.IComboService;

@Controller
@RequestMapping("intranet/combo")
public class ComboController {

    @Autowired
    private IBebidaService bebidaService;
    @Autowired
    private IComboService comboService;

    @RequestMapping("/")
    public String inicio(Combo combo, Model model){
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        List<Combo> lista = new ArrayList<>();
        lista = comboService.mostrarCombos();
       
        /*
        for(int i=0 ; i<lista.size(); i++){
            if(lista.get(i).getBebida() != null ){
                if(lista.get(i).getBebida().getId() == null)
                    lista.get(i).getBebida().setId(0L);
            }
        
        } */
        model.addAttribute("listaCombo", lista);
        return "sistema/combo";
    }
}
