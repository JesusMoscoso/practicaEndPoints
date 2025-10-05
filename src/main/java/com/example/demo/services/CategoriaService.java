package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriaDao;
import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.models.Categoria;

@Service
public class CategoriaService implements ICategoriaService {


    //inyectar el dao
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
       categoriaDao.deleteById(id);
    }

    @Override
    public Categoria findByCategoriaNombre(String nombre) {
       return categoriaDao.findByNombre(nombre);
    }
    
}
