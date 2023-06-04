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
            @RequestParam("email") String correo,
            @RequestParam("clave") String clave,
            @RequestParam("address") String direccion,
            Model model,
            Cliente cliente){

            Cliente cli = new Cliente();
            model.addAttribute("cliente", cli);

            Boolean emailDuplicado=false;
            listaClientes = iClienteService.listarClientes(); //llenar lista
            if(listaClientes.size()!=0){
                //buscar correo
                for(int i=0; i<listaClientes.size();i++){
                    if( listaClientes.get(i).getCorreo().equals("correo") ){
                            //correo ya existe!
                            model.addAttribute("errorEmail", "Correo ya registrado");
                            emailDuplicado= true;
                    }else{
                        //insertar cliente
                        emailDuplicado = false;
                    }
                }
            }else{
                //lista vacía
            }

            if(!emailDuplicado){
                    //iClienteService.registrarCliente(cliente);

                    return "redirect:/login";
                    
            }else{
                return "redirect:/registrarse";
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
                    model.addAttribute("errorMessage", "Credenciales incorrectas");
                    //return "login";
                }
                
            }
        }else{
            //bd vacía
            return "login";
        }
        
        if(b) return "intranet";
        else return "redirect:/login";
        
        
       
    }


    
}
