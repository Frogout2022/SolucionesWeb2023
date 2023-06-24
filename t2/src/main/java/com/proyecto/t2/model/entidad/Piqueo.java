package com.proyecto.t2.model.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="piqueo")
public class Piqueo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpiqueo")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;

    @Column(name="tipo")
    private String Tipo;

    @Column(name = "precio")
    private Double precio;

    @Column(name="porcion")
    private String porcion;
    
    @Column(name = "Stock")
    private int stock;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getPorcion() {
        return porcion;
    }
    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

}
