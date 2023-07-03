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

import com.proyecto.t2.model.dao.IRolDAO;
import com.proyecto.t2.model.dao.IUsuarioDAO;
import com.proyecto.t2.model.entidad.Cliente;
import com.proyecto.t2.model.entidad.Rol;
import com.proyecto.t2.model.entidad.Usuario;
import com.proyecto.t2.model.service.IClienteService;


@Controller
@RequestMapping("/cliente")
public class RegistroController {

    @Autowired
    private IClienteService iClienteService;
    @Autowired
    private IUsuarioDAO iUsuarioDAO;
    @Autowired
    private IRolDAO iRolDAO;

    
// #######################----------- REGISTRO ------------#################

    @GetMapping("/registro") //vista
    public String mostrarFormRegistro(
        Cliente cli //creamos objeto cliente para la vista
        ){
        
        return "/cliente/registrarse"; //ruta html
    }
    
    @PostMapping("/registro") //funcion del form
    public String procesarFormRegistro(
            @RequestParam("apellido") String apellido, //usa el atributo 'name'
            @RequestParam("username") String username,
            Model model,
            Cliente user //recuperamos el objeto user del POST
            ){

            Boolean emailDuplicado=false, telfDuplicado=false, usernameDuplicado = false;

            emailDuplicado = iClienteService.buscarCorreo(user.getCorreo());
            telfDuplicado = iClienteService.buscarCelular(user.getTelefono());
            Usuario usuarioFind = iUsuarioDAO.findByUsername(username);
            if(usuarioFind!= null) usernameDuplicado = true;
            
            if(!emailDuplicado && !telfDuplicado && !usernameDuplicado){
                    user.setNombre(user.getNombre()+" "+apellido); //añadir apellido
                    iClienteService.registrarCliente(user); // --> INSERT CLIENTE
                    
                    Usuario user_temp = new Usuario();
                    user_temp.setEmail_cli(user.getCorreo());
                    user_temp.setUsername(username);
                    user_temp.setEnabled(true);
                    //user_temp.setPassword(user.getClave());

                    //ecnriptar clave
                    String encrypString = SpringSecurityConfig.encriptarPassword().encode(user.getClave());
                    user_temp.setPassword(encrypString);

                    iUsuarioDAO.save(user_temp); // --> INSERT USUARIO
                    
                    Usuario user_temp2 = iUsuarioDAO.findByUsername(username);
                    if(user_temp2!=null){
                        Rol rol = new Rol();
                        rol.setAuthority("ROL_USUARIO");
                        rol.setUser_id(user_temp2.getId());
                        iRolDAO.save(rol); // --> INSERT ROL
                    }
                    


                    //mensaje
                    model.addAttribute("valid_reg", "Registro exitoso");
                    model.addAttribute("success", "Exitoso");
                    //ruta login
                    return "redirect:/polleria/login?success"; //NO usar redirect (se pierde el model)
                        
                    
            }else{ //datos ingresado no validos (error)
                if(telfDuplicado)
                    model.addAttribute("valid_telf", "Celular ya registrado");
                    
                if(emailDuplicado)
                    model.addAttribute("valid_email", "Correo ya registrado");

                if(usernameDuplicado)
                    model.addAttribute("valid_user", "(Usuario ya registrado)");

                model.addAttribute("apellido", apellido);
                return "cliente/registrarse"; //retornar vista
            }

            
        }


}
