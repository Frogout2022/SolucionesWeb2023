package com.proyecto.t2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/") //vista
    public String ingresar(){
        return "cliente/login"; //ruta html
    }
    @GetMapping("") //vista
    public String ingresar2(){
        return "cliente/login"; //ruta html
    }

    @GetMapping("/login") //vista
    public String login(){ 
        return "cliente/login"; //ruta html
    }

    @GetMapping("/login/") //vista
    public String login2(){
        return "cliente/login"; //ruta html
    }
    
    @GetMapping("/registro") //vista
    public String mostrarFormRegistro(
        Cliente cli //creamos objeto cliente para la vista
        ){
       
        return "/cliente/registrarse"; //ruta html
    }
    
    @PostMapping("/registro") //funcion del form
    public String procesarFormRegistro(
            @RequestParam("apellido") String apellido,
            Model model,
            Cliente user //recuperamos el objeto user del POST
            ){

            
            
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
                        
                        model.addAttribute("valid_reg", "Registro exitoso");
                        user.setNombre(user.getNombre()+" "+apellido); //añadir apellido
                        return "cliente/login"; //usar redirect se pierde el model
                        
                }else{ //datos ingresado no validos (error)
                    if(telfDuplicado){
                        model.addAttribute("valid_telf", "Celular ya registrado");
                        //result.rejectValue("correo", "error.cli", "El correo ya está registrado");
                    }
                       
                    if(emailDuplicado)
                        model.addAttribute("valid_email", "Correo ya registrado");

                    return "cliente/registrarse"; //retornar vista
                }

            }else{
                //lista de clientes en la BD vacía
                model.addAttribute("error", "Lista vacía de la tabla Cliente en BD");
                return "error/error";
            }

      //return "cliente/registrarse";
    }


    @PostMapping("/login") // funcion del form
    public String procesesarFormLogin(
        @ModelAttribute("cli") Cliente cli,
        @RequestParam("correo") String correo,
        @RequestParam("clave") String clave,
        Model model){
            
            //cli = new Cliente();
        //model.addAttribute("cli", cli);
        Boolean b= false;
        listaClientes = iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(int i=0; i<listaClientes.size(); i++){
                //buscar cliente
                if( correo.equals( listaClientes.get(i).getCorreo() ) 
                    && clave.equals( listaClientes.get(i).getClave() ) ) {
                    
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
            return "redirect:/intranet"; //usar redirect
        }
        else {
            model.addAttribute("errorLogin", "DATOS INCORRECTOS");
            return "/cliente/login"; //no usar redirect
        }

        //return "/";
        
        
       
    }


    
}
