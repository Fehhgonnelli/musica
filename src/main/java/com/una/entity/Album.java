package com.una.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Nome do Album obrigatório")
    private String nome;
    private Integer qtd_musicas;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artista", referencedColumnName = "id")
    private Artista artista;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    private Genero genero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_gravadora", referencedColumnName = "id")
    private Gravadora gravadora;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "album_midia", joinColumns = @JoinColumn(name = "id_album"), inverseJoinColumns = @JoinColumn(name = "id_midia"))
    private Set<Midia> midias;

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

    public Integer getQtd_musicas() {
        return qtd_musicas;
    }

    public void setQtd_musicas(Integer qtd_musicas) {
        this.qtd_musicas = qtd_musicas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    public Set<Midia> getMidias() {
        return midias;
    }

    public void setMidias(Set<Midia> midias) {
        this.midias = midias;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
