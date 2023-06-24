package com.proyecto.t2.model.service.sistema.interfaces;

import java.util.List;

import com.proyecto.t2.model.entidad.Combo;

public interface IComboService {
    public void guardarCombos(Combo combo);
    public List <Combo> mostrarCombos();
    public Combo buscarCombo(Long id);
    public void eliminarCombo(Long id);

}
