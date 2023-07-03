package com.proyecto.t2.model.entidad;


import java.util.List;

public class Sesion {
    //inicializar sesión
    public static boolean sesion = false;

    //cliente logueado
    public static Cliente user;
    public static boolean login_cli = false;

    //admin logueado
    public static Empleado emp;
    public static boolean login_emp = false;

    //recordar datos
    public static String correo = "";
    public static String clave = "";
    public static boolean recordar = false;

    public static boolean validar_admin(){
        if(sesion && login_emp) return true;
        return false;
    }
    public static boolean validar_cli(){
        if(sesion && login_cli) return true;
        return false;
    }

    
    public  boolean saveCliente(List<Cliente> listaClientes, String correo, String clave){
        Boolean guardado = false;
        user = new Cliente();
        
        for(Cliente cliente : listaClientes){
            if( correo.equals(cliente.getCorreo()) && clave.equals(cliente.getClave()) ){
                //encontrado
                user = cliente;
                guardado = true;
                break;
            }
        }
        return guardado;
    }

    public boolean saveEmpleado(List<Empleado> listaEmpleados, String usuario, String clave){
        boolean guardado = false;
        emp = new Empleado();
        for(Empleado empleado : listaEmpleados){
            if( usuario.equals(empleado.getUsuario()) && clave.equals(empleado.getClave()) ){
                //encontrado
                emp = empleado;
                guardado = true;
                break;
            }
        }
        return guardado;
    }


    
}
