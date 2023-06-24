package com.proyecto.t2.model.service.sistema.interfaces;

import java.util.List;
import com.proyecto.t2.model.entidad.Piqueo;

public interface IPiqueoService {
    public void guardarPiqueos(Piqueo piqueo);
    public List <Piqueo> mostrarPiqueos();
    public Piqueo buscarPiqueo(Long id);
    public void eliminarPiqueo(Long id);
}
