
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class InfoBasica {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    private String location;
    private String email;
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
    
    
    
    
}
