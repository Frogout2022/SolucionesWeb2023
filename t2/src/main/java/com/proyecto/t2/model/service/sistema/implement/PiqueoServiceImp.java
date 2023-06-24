package com.proyecto.t2.model.service.sistema.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.sistema.IPiqueoDAO;
import com.proyecto.t2.model.entidad.Piqueo;
import com.proyecto.t2.model.service.sistema.interfaces.IPiqueoService;

@Service
public class PiqueoServiceImp implements IPiqueoService {
    @Autowired
    IPiqueoDAO iPiqueoDAO;


    @Override
    public void guardarPiqueos(Piqueo piqueo) {
        iPiqueoDAO.save(piqueo);
       
    }

    @Override
    public List<Piqueo> mostrarPiqueos() {
        return (List<Piqueo>) iPiqueoDAO.findAll();
       
    }

    @Override
    public Piqueo buscarPiqueo(Long id) {
        return  iPiqueoDAO.findById(id).orElse(null);
        
    }

    @Override
    public void eliminarPiqueo(Long id) {
        iPiqueoDAO.deleteById(id);
        
    }
    
}
