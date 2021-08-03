package com.jandrocode.model.service;

import com.jandrocode.model.dao.IMetodoDAO;
import com.jandrocode.model.entities.Metodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoService {

    @Autowired
    private IMetodoDAO metodoDAO;

    public List<Metodo> listadoMetodos(){
        return metodoDAO.findAll();
    }

    public List<Metodo> buscadorMetodos(Long id,String nombreMetodo){
        return  metodoDAO.findByNombreMetodo(id,nombreMetodo);
    }

    public Metodo buscarMetodoPorId(Long id){
        return metodoDAO.findById(id).get();
    }

    public Metodo guardarMetodo(Metodo metodo){
        return metodoDAO.save(metodo);
    }

    public void eliminarMetodo(Long id){
        metodoDAO.deleteById(id);

    }
}
