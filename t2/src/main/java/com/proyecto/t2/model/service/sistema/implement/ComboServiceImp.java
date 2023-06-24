package com.proyecto.t2.model.service.sistema.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.sistema.IComboDAO;
import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.sistema.interfaces.IComboService;

@Service
public class ComboServiceImp implements IComboService{

    @Autowired
    private IComboDAO comboDAO;

    @Override
    public void guardarCombos(Combo combo) {
        comboDAO.save(combo);
        
    }

    @Override
    public List<Combo> mostrarCombos() {
        return (List<Combo>)  comboDAO.findAll();
        
    }

    @Override
    public Combo buscarCombo(Long id) {
        return comboDAO.findById(id).orElse(null);
        
    }

    @Override
    public void eliminarCombo(Long id) {
        comboDAO.deleteById(id);
        
    }
    
}
