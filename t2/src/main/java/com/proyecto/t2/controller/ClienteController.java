package com.proyecto.t2.controller;

import java.util.ArrayList;
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
    
    private List<Cliente> listaClientes;

    @RequestMapping("")
    public String ingresar(){
    
        return "login";
    }
    @RequestMapping("/")
    public String ingresar2(){
        
        return "login";
    }
    @RequestMapping("/registrar")
    public String registrar(@RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("celular") String cel,
            @RequestParam("correo") String correo,
            @RequestParam("clave") String clave,
            @RequestParam("address") String direccion,
            Model model,
            Cliente cliente){

            Cliente cli = new Cliente();
            model.addAttribute("cliente", cli);

            Boolean emailDuplicado=false;
            listaClientes = new ArrayList<>();

            listaClientes = iClienteService.listarClientes(); //llenar lista
            if(listaClientes.size()!=0){
                //buscar correo
                for(int i=0; i<listaClientes.size();i++){
                    if( correo.equals(listaClientes.get(i).getCorreo()) ){
                            //correo ya existe!
                            emailDuplicado= true;
                            break;
                    }
                }
                
                if(!emailDuplicado){
                    //INSERT CLIENTE
                        //iClienteService.registrarCliente(cliente);
                        model.addAttribute("correo_ingresado", correo);
                        return "login";
                        
                }else{
                    model.addAttribute("errorEmail", "Correo ya registrado");
                    return "registrarse";
                }

            }else{
                //lista de clientes en la BD vacía
                model.addAttribute("error", "Lista vacía de la tabla Cliente en BD");
                return "error/error";
            }

      // return "login";
    }
    @RequestMapping("/validar")
    public String validar(@RequestParam("correo") String correo,@RequestParam("clave") String clave, Model model){
        Boolean b= false;

        listaClientes = iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(int i=0; i<listaClientes.size(); i++){
                if( correo.equals( listaClientes.get(i).getCorreo() ) 
                    && clave.equals( listaClientes.get(i).getClave() ) ) {
                    //return "intranet";
                    b = true;
                }else{
                    
                    //return "login";
                }
                
            }
        }else{
            //bd vacía
            return "login";
        }
        
        if(b) return "intranet";
        else {
            model.addAttribute("errorMessage", "Credenciales incorrectas");
            return "login";
        }
        
        
       
    }


    
}
