package com.jandrocode.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jandrocode.model.entities.Metodo;
import com.jandrocode.model.service.CategoriaService;
import com.jandrocode.model.service.MetodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jandrocode.model.entities.Categoria;


@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private MetodoService metodoService;
	
	@GetMapping("")
	public List<Categoria> getCategorias(){
		return categoriaService.listadoCategorias();
	}
	
	@PostMapping("/guardar-categoria")
	public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria){
		
		Categoria cat;
		Map<String, Object> response = new HashMap<>();
		
		try {
		  cat = categoriaService.guardarCategoria(categoria);
		}catch (DataAccessException e) {
			response.put("error", "Error al guardar categoría en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("success", "Categoría creada");
		response.put("categoria", cat);
		
		return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}/{nombreMetodo}")
	public List <Metodo> buscadorMetodos(@PathVariable Long id, @PathVariable String nombreMetodo){
		return metodoService.buscadorMetodos(id,nombreMetodo);
	}

	@PutMapping("/actualizar/{id}")
	public Categoria actualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id){

		Categoria categoriaEncontrada = categoriaService.buscarCategoriaPorId(id);
		categoriaEncontrada.setNombreCategoria(categoria.getNombreCategoria());

		return  categoriaService.guardarCategoria(categoriaEncontrada);

	}

}
