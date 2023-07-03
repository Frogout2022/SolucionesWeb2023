package com.proyecto.t2.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.proyecto.t2.model.entidad.Carrito;


public interface ICarritoDAO extends CrudRepository<Carrito,Long>{
    
}
