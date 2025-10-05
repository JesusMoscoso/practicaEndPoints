package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Categoria;
import com.example.demo.services.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    //metodos del controlador
    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>>ListarCategorias() {
        try {
            return new ResponseEntity<>(categoriaService.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //registrar una categoria
    @PostMapping("/guardar")
    public ResponseEntity<Categoria>guardarCategoria (@RequestBody Categoria categoria) {
        try {
            return new ResponseEntity<>(categoriaService.save(categoria),HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    //buscar una categoria por nombre
    @GetMapping ("{nombre}")
    public ResponseEntity<Categoria> categoriaPorName(@PathVariable String nombre) {
       try {
        Categoria categoria = categoriaService.findByCategoriaNombre(nombre);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       } catch (Exception e) {
        return ResponseEntity.status(500).build();
       }
    }
    
    

}
