package com.proyecto.t2.model.service.sistema;

import java.util.List;

import com.proyecto.t2.model.entidad.Carrito;

public interface ICarritoService {
    public void guardarCarrito(Carrito carrito);
    //public List <Carrito> buscarProductos(Long id_cli);
    public List<Carrito> listarCarrito();
    
}
