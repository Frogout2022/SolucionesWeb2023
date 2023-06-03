package com.proyecto.t2.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.t2.model.entidad.Menu;

public interface IMenuDAO extends CrudRepository<Menu,Long> {
    
}
