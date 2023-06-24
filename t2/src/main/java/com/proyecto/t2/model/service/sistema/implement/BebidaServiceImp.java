package com.proyecto.t2.model.service.sistema.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IbebidaDAO;
import com.proyecto.t2.model.entidad.Bebida;
import com.proyecto.t2.model.service.sistema.interfaces.IBebidaService;

@Service
public class BebidaServiceImp implements IBebidaService{

    @Autowired
    private IbebidaDAO bebidaDAO;
    
    @Override
    public void guardarBebidas(Bebida bebida) {
        bebidaDAO.save(bebida);
    }
    @Override
    public List<Bebida> mostrBebidas() {
       return (List<Bebida>)bebidaDAO.findAll();
    }
    @Override
    public Bebida buscarBebida(Long id) {
        return bebidaDAO.findById(id).orElse(null);
    }
    @Override
    public void eliminarBebida(Long id) {
        bebidaDAO.deleteById(id);
    }
}