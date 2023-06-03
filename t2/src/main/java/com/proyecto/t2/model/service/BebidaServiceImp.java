package com.proyecto.t2.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IbebidaDAO;
import com.proyecto.t2.model.entidad.Bebida;

@Service
public class BebidaServiceImp implements IBebidaService{

    @Autowired
    private IbebidaDAO bebidaDAO;
    @Override
    public void guardarBebidas(Bebida bebida) {
        bebidaDAO.save(bebida);
    }
    
}