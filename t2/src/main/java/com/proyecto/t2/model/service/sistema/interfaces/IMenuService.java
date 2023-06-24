package com.proyecto.t2.model.service.sistema.interfaces;

import java.util.List;


import com.proyecto.t2.model.entidad.Menu;

public interface IMenuService {
    public void guardarMenu(Menu menu);
    public List<Menu> mostrarMenus();
    public Menu buscarMenu(Long id);
    public void eliminarMenu(Long id);
}