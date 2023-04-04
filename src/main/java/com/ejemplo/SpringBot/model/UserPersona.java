
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPersona", nullable = false)
    private Long idPersona;

    public Long getId() {
        return idPersona;
    }

    public void setId(Long id) {
        this.idPersona = id;
    }

    public String nombre;
    public String apellido;
    public String acercaDeMi;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAcercaDeMi() {
        return acercaDeMi;
    }

    public void setAcercaDeMi(String acercaDeMi) {
        this.acercaDeMi = acercaDeMi;
    }
}
