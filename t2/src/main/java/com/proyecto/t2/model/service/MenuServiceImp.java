package com.proyecto.t2.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IMenuDAO;
import com.proyecto.t2.model.entidad.Menu;

@Service
public class MenuServiceImp implements IMenuService{

    @Autowired
    private IMenuDAO menuDAO;
    @Override
    public void guardarMenu(Menu menu) {
        menuDAO.save(menu);
    }
}
