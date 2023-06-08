package com.proyecto.t2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.t2.model.entidad.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Long> {
    
}
