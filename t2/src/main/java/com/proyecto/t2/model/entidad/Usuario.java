package com.proyecto.t2.model.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private Boolean enabled;

    private String email_cli;
    private String email_emp;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "user_id")
    private List<Rol> roles;

    

    public String getEmail_cli() {
        return email_cli;
    }
    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }
    public String getEmail_emp() {
        return email_emp;
    }
    public void setEmail_emp(String email_emp) {
        this.email_emp = email_emp;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    
}
