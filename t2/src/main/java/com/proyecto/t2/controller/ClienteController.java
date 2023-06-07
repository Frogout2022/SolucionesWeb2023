package com.proyecto.t2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    
// #######################----------- REGISTRO ------------#################

    @GetMapping("/registro") //vista
    public String mostrarFormRegistro(
        Cliente cli //creamos objeto cliente para la vista
        ){
        if(Cliente.sesion) return "intranet";
        else return "/cliente/registrarse"; //ruta html
    }
    
    @PostMapping("/registro") //funcion del form
    public String procesarFormRegistro(
            @RequestParam("apellido") String apellido, //usa el atributo 'name'
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
                        user.setNombre(user.getNombre()+" "+apellido); //añadir apellido
                        iClienteService.registrarCliente(user); // --> INSERT CLIENTE
                        
                        //mensaje
                        model.addAttribute("valid_reg", "Registro exitoso");
                        
                        return "cliente/login"; //NO usar redirect (se pierde el model)
                        
                }else{ //datos ingresado no validos (error)
                    if(telfDuplicado){
                        model.addAttribute("valid_telf", "Celular ya registrado");
                        //result.rejectValue("correo", "error.cli", "El correo ya está registrado");
                    }
                       
                    if(emailDuplicado)
                        model.addAttribute("valid_email", "Correo ya registrado");

                        model.addAttribute("apellido", apellido);
                        return "cliente/registrarse"; //retornar vista
                }

            }else{
                //lista de clientes en la BD vacía
                model.addAttribute("error", "Lista vacía de la tabla Cliente en BD");
                return "error/error";
            }

      //return "cliente/registrarse";
    }

// #######################----------- LOGIN ------------#################
 
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
            return "redirect:/intranet"; //usar redirect
        }
        else {
            model.addAttribute("errorLogin", "Usuario o clave incorrectos");
            return "/cliente/login"; //no usar redirect
        }

        //return "/";
    
    }


    
}
