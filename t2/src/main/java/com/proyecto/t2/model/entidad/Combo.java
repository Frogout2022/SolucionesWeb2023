package com.proyecto.t2.model.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="combo")
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDcombo")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio")
    private Double precio;
    @Column(name = "Stock")
    private int stock;

    @Column(name="idbebida")
    private Integer id_bebida;
    @Column(name="idmenu")
    private Integer id_menu;
    @Column(name="idpollo")
    private Integer id_pollo;
    @Column(name="idpiqueo")
    private Integer id_piqueo;

    
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
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Integer getId_bebida() {
        return id_bebida;
    }
    public void setId_bebida(Integer id_bebida) {
        this.id_bebida = id_bebida;
    }
    public Integer getId_menu() {
        return id_menu;
    }
    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }
    public Integer getId_pollo() {
        return id_pollo;
    }
    public void setId_pollo(Integer id_pollo) {
        this.id_pollo = id_pollo;
    }
    public Integer getId_piqueo() {
        return id_piqueo;
    }
    public void setId_piqueo(Integer id_piqueo) {
        this.id_piqueo = id_piqueo;
    }

    

    


}
