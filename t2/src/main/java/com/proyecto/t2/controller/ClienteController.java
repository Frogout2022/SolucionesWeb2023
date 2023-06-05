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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;
    
    private List<Cliente> listaClientes;

    @RequestMapping("/login")
    public String ingresar(){
    
        return "cliente/login"; //ruta html
    }
    @RequestMapping("/login/")
    public String ingresar2(){
        
        return "login";
    }
    
    @RequestMapping("/registrarse")
    public String registrarse(Model model){

        Cliente cliente = new Cliente();
        model.addAttribute("cli", cliente);
        
    
        return "cliente/registrarse"; //ruta html
    }
    

    @RequestMapping("/guardar")
    public String registrar(
            @RequestParam("apellido") String apellido,
            Model model,
            Cliente user //recuperamos el objeto user del POST
            ){

            user.setNombre(user.getNombre()+" "+apellido); //añadir apellido
            
            Boolean emailDuplicado=false, telfDuplicado=false;

            listaClientes = new ArrayList<>(); //inicializar lista
            listaClientes = iClienteService.listarClientes(); //llenar lista
            if(listaClientes.size()!=0){
                
                for(int i=0; i<listaClientes.size();i++){
                    //buscar correo
                    if( user.getCorreo().equals(listaClientes.get(i).getCorreo()) ){
                            //correo ya existe!
                            emailDuplicado= true;  
                    }
                    //buscar telefono
                    if( user.getTelefono().equals(listaClientes.get(i).getTelefono()) ){
                        //telefono ya existe!
                        telfDuplicado= true;   
                    }
                }
                
                if(!emailDuplicado && !telfDuplicado){
                        iClienteService.registrarCliente(user); // --> INSERT CLIENTE
                        
                        model.addAttribute("mensaje_registro", "Registro exitoso");
                        return "cliente/login";
                        
                }else{
                    //if(telfDuplicado)
                    model.addAttribute("valid_reg");
                    //if(emailDuplicado)
                    model.addAttribute("validacion_email", "Correo ya registrado");
                    
                    return "redirect:/cliente/registrarse";
                }

            }else{
                //lista de clientes en la BD vacía
                model.addAttribute("error", "Lista vacía de la tabla Cliente en BD");
                return "error/error";
            }

      // return "login";
    }


    @RequestMapping("/validar")
    public String validar(
        @RequestParam("correo") String correo,
        @RequestParam("clave") String clave, 
        Model model){

        Boolean b= false;

        listaClientes = iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(int i=0; i<listaClientes.size(); i++){
                if( correo.equals( listaClientes.get(i).getCorreo() ) 
                    && clave.equals( listaClientes.get(i).getClave() ) ) {
                    //return "intranet";
                    b = true;
                    break;
                }
            }
        }else{
            //bd vacía
            model.addAttribute("errorMessage","Tabla cliente en Base de datos vacía");
            return "error/error";
        }
        
        if(b) return "intranet";
        else {
            model.addAttribute("errorMessage", "Usuario o clave incorrectas");
            return "redirect:/cliente/login";
        }
        
        
       
    }


    
}
