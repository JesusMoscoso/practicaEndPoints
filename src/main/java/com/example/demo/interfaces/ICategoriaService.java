package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.models.Categoria;

public interface ICategoriaService {
    
    //metodos para el crud

    //listar todas las categorias
    public List<Categoria> findAll();

    //obter una categoria por id
    public Categoria findById(Long id);

    //guardar una categoria
    public Categoria save(Categoria categoria);

    //eliminar una categoria por id
    public void deleteById(Long id);

    //actualizar una categoria
    public Categoria findByCategoriaNombre(String nombre);

}
