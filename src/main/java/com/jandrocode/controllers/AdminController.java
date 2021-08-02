package com.jandrocode.controllers;

import com.jandrocode.model.entities.Categoria;
import com.jandrocode.model.entities.Metodo;
import com.jandrocode.model.service.CategoriaService;
import com.jandrocode.model.service.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MetodoService metodoService;

    @GetMapping("/listado-categorias")
    public List<Categoria> categoriasListado(){
        return categoriaService.listadoCategorias();
    }

    @GetMapping("/listado-metodos")
    public List<Metodo> metodosListado(){
        return metodoService.listadoMetodos();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCategoria(@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
    }

    @GetMapping("/buscar-categoria/{id}")
    public ResponseEntity <?> buscarCategoria(@PathVariable Long id){

        Categoria categoria = null;
        Map<String, Object> response = new HashMap<>();
        categoria = categoriaService.buscarCategoriaPorId(id);

        if(categoria == null){
            response.put("message","La categoría no existe");
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }

}
