package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.service.IClienteService;

@Controller
@RequestMapping("/login")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @RequestMapping("")
    public String ingresar(){
        return "login";
    }
    @RequestMapping("/")
    public String ingresar2(){
        return "login";
    }

    @RequestMapping("/validar")
    public String validar(@RequestParam("correo") String correo,@RequestParam("clave") String clave, Model model){

        //cliente = iClienteService.buscarCliente(id);
        //model.addAttribute("cliente", cliente);
        
        model.addAttribute("mensaje", "entro");
        Boolean b= false;
        List<Cliente> listaClientes =  iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(int i=0; i<listaClientes.size(); i++){
                if( correo.equals( listaClientes.get(i).getCorreo() ) 
                    && clave.equals( listaClientes.get(i).getClave() ) ) {
                    //return "intranet";
                    b = true;
                }else{
                    model.addAttribute("errorMessage", "Credenciales incorrectas");
                    //return "login";
                }
                
            }
        }else{
            //bd vacía
            return "login";
        }
        
        if(b) return "intranet";
        else return "login";
        
        
       
    }


    
}
