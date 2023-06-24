package com.proyecto.t2.model.service.sistema.interfaces;

import java.util.List;

import com.proyecto.t2.model.entidad.Bebida;

public interface IBebidaService {
    public void guardarBebidas(Bebida bebida);
    public List <Bebida> mostrBebidas();
    public Bebida buscarBebida(Long id);
    public void eliminarBebida(Long id);
}
