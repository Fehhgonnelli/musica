package com.una.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Artista {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Nome do Artista obrigatorio")
    private String nome;
    private Integer ano_formacao;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    private Genero genero;



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

    public Integer getAno_formacao() {
        return ano_formacao;
    }

    public void setAno_formacao(Integer ano_formacao) {
        this.ano_formacao = ano_formacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
