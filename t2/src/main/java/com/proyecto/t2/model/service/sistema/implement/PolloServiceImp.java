package com.proyecto.t2.model.service.sistema.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.sistema.IPolloDAO;
import com.proyecto.t2.model.entidad.Pollo;
import com.proyecto.t2.model.service.sistema.interfaces.IPolloService;

@Service
public class PolloServiceImp implements IPolloService{
    @Autowired IPolloDAO iPolloDAO;

    @Override
    public void guardarPollos(Pollo pollo) {
        iPolloDAO.save(pollo);
    }

    @Override
    public List<Pollo> mostrarPollos() {
        return (List<Pollo>) iPolloDAO.findAll();
    }

    @Override
    public Pollo buscarPollo(Long id) {
        return iPolloDAO.findById(id).orElse(null);
        
    }

    @Override
    public void eliminarPollo(Long id) {
        iPolloDAO.deleteById(id);
       
    }
    
}
