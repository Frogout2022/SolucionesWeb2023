package com.proyecto.t2.model.service.sistema.implement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IMenuDAO;
import com.proyecto.t2.model.entidad.Menu;
import com.proyecto.t2.model.service.sistema.interfaces.IMenuService;

@Service
public class MenuServiceImp implements IMenuService{

    @Autowired
    private IMenuDAO menuDAO;

    @Override
    public void guardarMenu(Menu menu) {
        menuDAO.save(menu);
    }

    @Override
    public List<Menu> mostrarMenus(){
        return (List<Menu>)menuDAO.findAll();
    }

    @Override
    public Menu buscarMenu(Long id){
        return menuDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarMenu(Long id) {
        menuDAO.deleteById(id);
    }
}