
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Entrar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String email;
    private String password;

    public Entrar() {
    }

    public Entrar(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
}
