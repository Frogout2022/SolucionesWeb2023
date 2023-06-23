package com.proyecto.t2.model.entidad;

import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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


    @ManyToOne
    @JoinColumn(name= "idbebida")
    private Bebida bebida;

    @ManyToOne
    @JoinColumn(name= "idmenu")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="idpiqueo")
    private Piqueo piqueo;

    @ManyToOne
    @JoinColumn(name="idpollo")
    private Pollo pollo;

    
    
    
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
    
    
    public Bebida getBebida() {
        return bebida;
    }
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public Piqueo getPiqueo() {
        return piqueo;
    }
    public void setPiqueo(Piqueo piqueo) {
        this.piqueo = piqueo;
    }
    public Pollo getPollo() {
        return pollo;
    }
    public void setPollo(Pollo pollo) {
        this.pollo = pollo;
    }


}
