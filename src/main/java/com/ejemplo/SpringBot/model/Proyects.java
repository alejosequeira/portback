
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Proyects {    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String inicio;
    private String fin;
    private String descripcion;

    public Proyects() {
    }
      
    public Proyects(Long id, String titulo, String inicio, String fin, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
    }
    
    
}
