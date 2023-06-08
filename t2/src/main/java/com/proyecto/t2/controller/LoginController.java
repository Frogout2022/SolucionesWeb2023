package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.entidad.User;
import com.proyecto.t2.model.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class LoginController {
    
    
    @Autowired
    private IClienteService iClienteService;
    
    private List<Cliente> listaClientes;


// #######################----------- LOGIN CLIENTE ------------#################
 
    @GetMapping("/login") //vista
    public String login(Cliente cli, Model model){ 
        if(Cliente.sesion){
            return "intranet";
        }else{
            if(Cliente.recordar){
                model.addAttribute("usuario",Cliente.usuario);
                model.addAttribute("contra", Cliente.contra);
                model.addAttribute("activo", "true");
            }
            

            return "cliente/login"; //ruta html
        }
        
    }
    @GetMapping("/loginS")
    public String login2(Cliente cli, Model model){
        Cliente.sesion = false;
        if(Cliente.recordar){
            model.addAttribute("usuario",Cliente.usuario);
            model.addAttribute("contra", Cliente.contra);
            model.addAttribute("activo", "true");
        }

        return "cliente/login";
    }

    @PostMapping("/login") // funcion del form
    public String procesesarFormLogin(
        @RequestParam(value = "recuerdame", required = false) Boolean recordar,    
        Cliente cli,
        Model model
       
    ){
        
        if(recordar!=null && recordar){
            Cliente.recordar = true;
            Cliente.usuario = cli.getCorreo();
            Cliente.contra = cli.getClave();
        }else{
            Cliente.recordar = false;
        }

        Boolean b= false;
        listaClientes = iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(int i=0; i<listaClientes.size(); i++){
                //buscar cliente
                if( cli.getCorreo().equals( listaClientes.get(i).getCorreo() ) 
                    && cli.getClave().equals( listaClientes.get(i).getClave() ) ) {
                    
                    b = true; //cliente encontrado
                    break;
                }
            }
        }else{
            //bd vacía
            model.addAttribute("errorMessage","Tabla cliente en Base de datos vacía");
            return "error/error";
        }
        
        if(b) {
            Cliente.sesion = true;
            //guardar cliente
            User user = new User();
            if(user.saveCliente(listaClientes, cli.getCorreo(), cli.getClave())){
                return "redirect:/intranet"; //usar redirect
            }else{
                model.addAttribute("error", "Error al guardar user");
                return "redirect:/error/errror";
            } 
           
        }
        else {
            model.addAttribute("errorLogin", "Usuario o clave incorrectos");
            return "/cliente/login"; //no usar redirect
        }

        //return "/";
    
    }
}
