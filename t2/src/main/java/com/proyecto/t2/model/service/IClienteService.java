package com.proyecto.t2.model.service;

import java.util.List;
import com.proyecto.t2.model.entidad.Cliente;

public interface IClienteService {
    public void registrarCliente(Cliente cliente);
    public List<Cliente> listarClientes();
    public Cliente buscarCliente(Long id);
   
    
    
}
