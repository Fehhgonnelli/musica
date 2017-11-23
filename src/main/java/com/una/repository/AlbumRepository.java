package com.una.repository;

import com.una.entity.Album;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface AlbumRepository extends JpaRepository<Album,Integer> {
	 Page<Album> findByNomeLike(String nome,Pageable pageable);
}