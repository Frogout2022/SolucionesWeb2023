package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Menu;
import com.proyecto.t2.model.service.sistema.interfaces.IMenuService;

@Controller
@RequestMapping("intranet/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @RequestMapping("/")
    public String inicio(Model model){
        Menu menu=new Menu();
        model.addAttribute("menu", menu);
        model.addAttribute("titulo", "Registrar nuevo menu");
        model.addAttribute("listaMenu", menuService.mostrarMenus());
        return "sistema/menu";
        
    }

    @RequestMapping("/guardar")
    public String guardar(Menu menu){
        menuService.guardarMenu(menu);
        return "redirect:/intranet/menu/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
       
        Menu Menu = new Menu();
        Menu = menuService.buscarMenu(id);
        model.addAttribute("menu", Menu);
        model.addAttribute("titulo", "Modificar menu");
        model.addAttribute("listaMenu", menuService.mostrarMenus());
        return "sistema/menu"; 
    
        
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        menuService.eliminarMenu(id);
        return "redirect:/intranet/menu/";
    }
}
