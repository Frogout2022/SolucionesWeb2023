package com.proyecto.t2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.entidad.Empleado;
import com.proyecto.t2.model.entidad.Sesion;
import com.proyecto.t2.model.service.IClienteService;
import com.proyecto.t2.model.service.IEmpleadoService;


@Controller
public class LoginController {
    
    @Autowired
    private IClienteService iClienteService;
    @Autowired
    private IEmpleadoService iEmpleadoService;

    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;
 
    @GetMapping("/login") //vista
    public String login(Cliente cli, Model model){ 
        if(Sesion.sesion){
            if(Sesion.login_cli) return "redirect:/extranet"; //link
            if(Sesion.login_emp) return "redirect:/intranet"; //link
        }else{
            if(Sesion.recordar){
                model.addAttribute("usuario",Sesion.correo);
                model.addAttribute("contra", Sesion.clave);
                model.addAttribute("activo", "true");
            }
           return "cliente/login"; //ruta html
        }
        return "";
        
    }
    @GetMapping("/loginClose") //cerrar sesión
    public String login2(Cliente cli, Model model){
        if(Sesion.sesion) Sesion.sesion = false; //cerrar sesión
        if(Sesion.login_cli) Sesion.login_cli = false;
        if(Sesion.login_emp) Sesion.login_emp = false;

         
        if(Sesion.recordar){
            model.addAttribute("usuario",Sesion.correo);
            model.addAttribute("contra", Sesion.clave);
            model.addAttribute("activo", "true");
        }

        return "cliente/login";
    }

    @PostMapping("/login") //   <-- FUNCION DEL FORM DEL HTML
    public String procesesarFormLogin(
        @RequestParam(value = "recuerdame", required = false) Boolean recordar,    
        Cliente cli,
        Model model
       
    ){
        
        
        

        if(buscarCli(cli.getCorreo(),cli.getClave())) {//CLIENTE ENCONTRADO
            //INICIALIZAR LA SESIÓN
            Sesion.sesion = true; 
            Sesion.login_cli = true;

            //guardar cliente para luego obtener sus datos
            Sesion user = new Sesion();
            if(user.saveCliente(listaClientes, cli.getCorreo(), cli.getClave())){
                //REDIRECCIÓN A LA EXTRANET
                {
                    if(recordar!=null && recordar){
                        Sesion.recordar = true;
                        Sesion.correo = cli.getCorreo();
                        Sesion.clave = cli.getClave();
                    }else Sesion.recordar = false;

                }

                return "redirect:/extranet"; //usar redirect
            }else{
                model.addAttribute("error", "Error al guardar user");
                return "redirect:/error/errror";
            } 
        }else {//CLIENTE NO ENCONTRADO
            //BUSCAR ADMIN
            if(buscarAdmin(cli.getCorreo(), cli.getClave())){//ADMIN ENCONTRADO
                //INICIALIZAR LA SESIÓN
                Sesion.sesion = true; 
                Sesion.login_emp = true;

                //GUARDAR AL ADMIN
                //--------opcional ------------
                
                {
                    if(recordar!=null && recordar){
                        Sesion.recordar = true;
                        Sesion.correo = cli.getCorreo();
                        Sesion.clave = cli.getClave();
                    }else Sesion.recordar = false;

                }

                return "empleado/intranet"; //ruta html
            }else{
                model.addAttribute("errorLogin", "Usuario o clave incorrectos");
                return "cliente/login"; //no usar redirect
            }
            
        }
        //return "/";
    }
    private Boolean buscarCli(String correo, String clave){
        boolean encontrado = false;
        listaClientes = new ArrayList<>();
        listaClientes = iClienteService.listarClientes();
        if(listaClientes.size()!=0){
            for(Cliente cliente : listaClientes){
                if(correo.equals(cliente.getCorreo()) && clave.equals(cliente.getClave()) ){
                    encontrado = true;
                    break;
                }
            }
        }else{
            //tabla vacía clientes
            return false;
        }

        return encontrado;
    }


    private Boolean buscarAdmin(String usuario, String clave){
        boolean encontrado=false;
        listaEmpleados = new ArrayList<>();
        listaEmpleados = iEmpleadoService.listarEmpleado();

        if(listaEmpleados.size()!=0){
            for(Empleado empleado : listaEmpleados){
                if(usuario.equals(empleado.getUsuario())  && clave.equals(empleado.getClave())){
                    encontrado = true; //empleado encontrado
                    break;
                }
            }
        }else{
            //tabla vacía de empleados
            return false;
        }
       
        return encontrado;
    }



}
