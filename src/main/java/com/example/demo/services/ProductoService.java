package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductoDao;
import com.example.demo.interfaces.IProductoService;
import com.example.demo.models.Producto;

@Service
public class ProductoService implements IProductoService {

    //inyectar el dao
    @Autowired
    private ProductoDao productoDao;

    //listar todos los productos
    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    //obter un producto por id
    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public Producto update(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public List<Producto> productosCaros() {
        return productoDao.findProductosCaros();
    }

    @Override
    public List<Producto> productosDeTecnologia() {
        return productoDao.findProductosDeTecnologia();
    }

    @Override
    public List<Producto> productosDeUnaCategoriaEspecifica(Long categoriaId) {
        return productoDao.findProductosDeUnaCategoriaEspecifica(categoriaId);
    }
    
}
