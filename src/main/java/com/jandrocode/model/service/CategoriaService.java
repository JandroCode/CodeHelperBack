package com.jandrocode.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jandrocode.model.dao.ICetegoriaDAO;
import com.jandrocode.model.entities.Categoria;

@Service
public class CategoriaService {
	
	@Autowired
	private ICetegoriaDAO categoriaDao;
	
	//listar categorías
	public List<Categoria> listadoCategorias(){
		return categoriaDao.findAll();
	}
	
	//Guardar categorías
	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	//Buscar categoría por id
	public Categoria buscarCategoriaPorId(Long id){
		Categoria categoria = categoriaDao.findById(id).orElse(null);
		return categoria;
	}

	//Eliminar categorías
	public void eliminarCategoria(Long id){
		categoriaDao.deleteById(id);

	}
}
