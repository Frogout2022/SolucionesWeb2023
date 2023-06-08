package com.proyecto.t2.model.service;

import java.util.List;

import com.proyecto.t2.model.entidad.Empleado;

public interface IEmpleadoService {
    public void registrarEmpleado(Empleado empleado);
    public List<Empleado> listarEmpleado();
    public Empleado buscarEmpleado(Long id);
    
    
}
