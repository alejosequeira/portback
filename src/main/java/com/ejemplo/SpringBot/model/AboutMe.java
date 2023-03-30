
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String descripcion;

    public AboutMe() {
    }

    public AboutMe(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    

}
