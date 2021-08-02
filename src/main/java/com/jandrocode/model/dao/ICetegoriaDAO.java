package com.jandrocode.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jandrocode.model.entities.Categoria;

@Repository
public interface ICetegoriaDAO extends JpaRepository<Categoria, Long> {

}
