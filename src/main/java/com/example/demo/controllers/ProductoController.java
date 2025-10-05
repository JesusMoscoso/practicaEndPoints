package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Producto;
import com.example.demo.services.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController //indica que es un controlador
@RequestMapping("/api/productos") //ruta del controlador    
public class ProductoController {
    
    //inyectar el servicio
    @Autowired
    private ProductoService productoService;

    //obtener todos los productos
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>>listarProductos() {
            try {
            return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //obtener los productos con precio mayor a 60000
    @GetMapping("/caros")
    public ResponseEntity<List<Producto>>productosCaros() {
        try {
            return new ResponseEntity<>(productoService.productosCaros(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    //obtener los productos de la categoria tecnologia
    @GetMapping("/tecnologia")
    public ResponseEntity<List<Producto>>productosDeTecnologia() {
        try {
            return new ResponseEntity<>(productoService.productosDeTecnologia(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //obtener un producto por id
    //puede ser
    @GetMapping("/{id}")
    public ResponseEntity<Producto>productoById(@PathVariable Long id) {
        try {
            Producto producto = productoService.findById(id);
            if (producto != null) {
                return new ResponseEntity<>(producto,HttpStatus.OK);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
           return ResponseEntity.status(500).build();
        }
    }
    
    //crear un nuevo producto
    @PostMapping("/guardar")
    public ResponseEntity<Producto>guardarProducto(@RequestBody Producto producto) {
        try {
            return new ResponseEntity<>(productoService.save(producto),HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //eliminar un producto por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void>eliminarProducto(@PathVariable Long id) {
        try {
            Producto producto = productoService.findById(id);
            if (producto != null) {
                productoService.deleteById(id);
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //obtenr productos de una categoria especifica
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Producto>>productosDeUnaCategoriaEspecifica(@PathVariable Long categoriaId) {
        try {
            return new ResponseEntity<>(productoService.productosDeUnaCategoriaEspecifica(categoriaId),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }





    
}
