package com.ejemplo.SpringBot.model;

import jakarta.persistence.*;

@Entity
@Table (name= "educationt")
public class Educationt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulot", length = 60, nullable = false)
    private String titulot;

    @Column(name = "iniciot", length = 60, nullable = false)
    private String iniciot;

    @Column(name = "fint", length = 60, nullable = false)
    private String fint;
    @Column(name = "descriptiont", length = 60, nullable = false)
    private String descriptiont;

    public Educationt() {
    }

    public Educationt(Long id, String titulot, String iniciot, String fint, String descriptiont) {
        super();
        this.id = id;
        this.titulot = titulot;
        this.iniciot = iniciot;
        this.fint = fint;
        this.descriptiont = descriptiont;
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

    public String getIniciot() {
        return iniciot;
    }

    public void setIniciot(String iniciot) {
        this.iniciot = iniciot;
    }

    public String getFint() {
        return fint;
    }

    public void setFint(String fint) {
        this.fint = fint;
    }

    public String getDescriptiont() {
        return descriptiont;
    }

    public void setDescriptiont(String descriptiont) {
        this.descriptiont = descriptiont;
    }

}
