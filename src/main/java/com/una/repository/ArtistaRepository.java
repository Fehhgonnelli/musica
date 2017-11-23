package com.una.repository;

import com.una.entity.Artista;
import org.springframework.data.repository.CrudRepository;


public interface ArtistaRepository extends CrudRepository<Artista,Integer> {
}