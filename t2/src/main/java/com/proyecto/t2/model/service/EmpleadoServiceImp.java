package com.proyecto.t2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IEmpleadoDAO;
import com.proyecto.t2.model.entidad.Empleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {
    @Autowired
    private IEmpleadoDAO iEmpleadoDAO;

    @Override
    public void registrarEmpleado(Empleado empleado) {
        iEmpleadoDAO.save(empleado);
    }

    @Override
    public List<Empleado> listarEmpleado() {
        return (List<Empleado>)iEmpleadoDAO.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
        return iEmpleadoDAO.findById(id).orElse(null);
    }
}
