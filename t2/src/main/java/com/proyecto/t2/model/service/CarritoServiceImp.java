package com.proyecto.t2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.ICarritoDAO;
import com.proyecto.t2.model.entidad.Carrito;
import com.proyecto.t2.model.service.sistema.ICarritoService;

@Service
public class CarritoServiceImp implements ICarritoService {

    @Autowired
    ICarritoDAO iCarritoDAO;

    @Override
    public void guardarCarrito(Carrito carrito) {
       iCarritoDAO.save(carrito);
    }

    @Override
    public List<Carrito> listarCarrito() {
       return (List<Carrito>) iCarritoDAO.findAll();
        
    }


    
    
}
