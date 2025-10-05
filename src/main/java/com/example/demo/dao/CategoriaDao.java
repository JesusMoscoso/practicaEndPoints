package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

    //obtener categorias por nombre
    public Categoria findByNombre(String nombre);

}
