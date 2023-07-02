package com.proyecto.t2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.t2.model.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario,Long>{
    public Usuario findByUsername(String username);

}
