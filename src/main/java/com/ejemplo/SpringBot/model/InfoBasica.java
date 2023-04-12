
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "info")
public class InfoBasica {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "description", length = 60, nullable = false)
    private String description;
    @Column(name = "location", length = 60, nullable = false)
    private String location;
    @Column(name = "email", length = 60, nullable = false)
    private String email;
    @Column(name = "numero", length = 60, nullable = false)
    private Long numero;

    public InfoBasica() {
    }

    public InfoBasica(Long id, String description, String location, String email, Long numero) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.email = email;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }       
    }
