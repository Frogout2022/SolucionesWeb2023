package com.proyecto.t2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.t2.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente,Long> {
    public Cliente findByCorreo(String correo);
    public Cliente findByTelefono(String celular);
    
}
