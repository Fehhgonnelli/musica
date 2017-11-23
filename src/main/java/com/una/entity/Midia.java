package com.una.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Midia {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Informe o Tipo")
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
