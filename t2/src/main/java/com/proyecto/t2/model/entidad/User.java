package com.proyecto.t2.model.entidad;


import java.util.List;

public class User {

    //cliente logueado
    public static Cliente user;
    
    public  boolean saveCliente(List<Cliente> listaClientes, String correo, String clave){
        Boolean guardado = false;
        user = new Cliente();
        
        for(int i=0 ; i<listaClientes.size(); i++){
            if( correo.equals(listaClientes.get(i).getCorreo()) 
                && clave.equals(listaClientes.get(i).getClave()) )
            {//encontrado
                user = listaClientes.get(i);
                guardado = true;
                break;
            }
        }
        
        return guardado;
    }


    
}
