package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.t2.model.entidad.Menu;
import com.proyecto.t2.model.entidad.User;
import com.proyecto.t2.model.service.IMenuService;

@Controller
@RequestMapping("intranet/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @RequestMapping("/")
    public String inicio(Model model){
        if(User.sesion && User.login_emp){//validar sesion del admin
            Menu menu=new Menu();
            model.addAttribute("menu", menu);
            model.addAttribute("titulo", "Registrar nuevo menu");
            model.addAttribute("listaMenu", menuService.mostrarMenus());
            return "sistema/menu";
        }
        return "redirect:/login";
        
    }

    @RequestMapping("/guardar")
    public String guardar(Menu menu){
        menuService.guardarMenu(menu);
        return "redirect:/intranet/menu/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        if(User.sesion && User.login_emp){ //validar la sesion del admin
            Menu Menu = new Menu();
            Menu = menuService.buscarMenu(id);
            model.addAttribute("menu", Menu);
            model.addAttribute("titulo", "Modificar menu");
            model.addAttribute("listaMenu", menuService.mostrarMenus());
            return "sistema/menu"; 
        }
        return "redirect:/login";

        
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        menuService.eliminarMenu(id);
        return "redirect:/intranet/menu/";
    }
}