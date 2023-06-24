package com.proyecto.t2.model.service.sistema.interfaces;

import java.util.List;

import com.proyecto.t2.model.entidad.Pollo;

public interface IPolloService {
    public void guardarPollos(Pollo pollo);
    public List <Pollo> mostrarPollos();
    public Pollo buscarPollo(Long id);
    public void eliminarPollo(Long id);
}
