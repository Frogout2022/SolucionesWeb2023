package com.proyecto.t2.model.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcarro;

    private Long id_cli;
    private double subtotal;
    private double precio_prod;
    private String nom_prod;
    private int cantidad_prod;
    
    public Long getIdcarro() {
        return idcarro;
    }
    public void setIdcarro(Long idcarro) {
        this.idcarro = idcarro;
    }
    public Long getId_cli() {
        return id_cli;
    }
    public void setId_cli(Long id_cli) {
        this.id_cli = id_cli;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getPrecio_prod() {
        return precio_prod;
    }
    public void setPrecio_prod(double precio_prod) {
        this.precio_prod = precio_prod;
    }
    public String getNom_prod() {
        return nom_prod;
    }
    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }
    public int getCantidad_prod() {
        return cantidad_prod;
    }
    public void setCantidad_prod(int cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }
    
    

}
