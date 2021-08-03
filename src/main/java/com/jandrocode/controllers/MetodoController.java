package com.jandrocode.controllers;

import com.jandrocode.model.entities.Categoria;
import com.jandrocode.model.entities.Metodo;
import com.jandrocode.model.service.CategoriaService;
import com.jandrocode.model.service.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/metodos")
public class MetodoController {

    @Autowired
    private MetodoService metodoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/lista")
    public List<Metodo> listaMetodos(){
        return metodoService.listadoMetodos();
    }

    //GUARDAR MÉTODOS
    @PostMapping("/guardar-metodo/{id}")
    public Metodo guardarMetodo(@RequestBody Metodo metodo, @PathVariable Long id){

        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        metodo.setCategoria(categoria);
        Metodo method = metodoService.guardarMetodo(metodo);

        return method;
    }

    //BUSCAR MÉTODOS POR ID
    @GetMapping("/{id}")
    public Metodo buscarPorId(@PathVariable Long id){
        return metodoService.buscarMetodoPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Metodo actualizarMetodo(@RequestBody Metodo metodo, @PathVariable Long id){

        Metodo metodoEncontrado = metodoService.buscarMetodoPorId(id);
        metodoEncontrado.setNombreMetodo(metodo.getNombreMetodo());
        metodoEncontrado.setUrl(metodo.getUrl());

        return  metodoService.guardarMetodo(metodoEncontrado);
    }

    //ELIMINAR MÉTODOS
    @DeleteMapping("/eliminar/{id}")
    public void eliminarMetodo(@PathVariable Long id){
        metodoService.eliminarMetodo(id);
    }

}
