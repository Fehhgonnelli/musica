package com.una.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Genero {


    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Tipo de Genero Obrigatorio")
    private String tipo;

    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
