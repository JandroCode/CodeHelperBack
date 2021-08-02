package com.jandrocode.model.dao;

import com.jandrocode.model.entities.Metodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMetodoDAO extends JpaRepository<Metodo,Long> {

    //Método para buscar métodos en función del nombre del método y de la categoría
    @Query(value="SELECT m from Metodo m WHERE m.categoria.id =:id AND m.nombreMetodo LIKE %:nombreMetodo%")
    List<Metodo> findByNombreMetodo(@Param("id")Long id, @Param("nombreMetodo")String nombreMetodo);


}
