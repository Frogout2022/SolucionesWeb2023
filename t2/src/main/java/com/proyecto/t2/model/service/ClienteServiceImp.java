package com.proyecto.t2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.t2.model.dao.IClienteDAO;
import com.proyecto.t2.model.entidad.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {
    
    @Autowired
    private IClienteDAO iClienteDAO;

    @Override
    public void registrarCliente(Cliente cliente) {
        iClienteDAO.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>)iClienteDAO.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return iClienteDAO.findById(id).orElse(null);
    }

    @Override
    public Boolean buscarCorreo(String correo) {
        Cliente cli = iClienteDAO.findByCorreo(correo);
        if(cli== null) return false;
        else return true;
    }

    @Override
    public Boolean buscarCelular(String celular) {
        Cliente cli = iClienteDAO.findByTelefono(celular);
        if(cli == null) return false;
        else return true;
    }

    
}
