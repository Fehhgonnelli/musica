package com.una.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Gravadora {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Informe o Nome")
    private String nome;
    @NotNull(message = "Informe o Cnpj")
    private Double cnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCnpj() {
        return cnpj;
    }

    public void setCnpj(Double cnpj) {
        this.cnpj = cnpj;
    }
}
