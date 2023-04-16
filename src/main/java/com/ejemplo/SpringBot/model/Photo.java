/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name= "photo")
public class Photo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "titulot", length = 60, nullable = false)
    private String titulot;
    

    public Photo() {
    }

    public Photo(Long id, String titulot) {
        this.id = id;
        this.titulot = titulot;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulot() {
        return titulot;
    }

    public void setTitulot(String titulot) {
        this.titulot = titulot;
    }

   
}
