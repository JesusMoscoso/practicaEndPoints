package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Producto;

public interface ProductoDao  extends JpaRepository<Producto, Long>{
    
    //obtenr los productos en donde el precio se mas de 60000
    @Query(
        value = "SELECT * FROM productos WHERE precio > 60000",
        nativeQuery = true
    )
    List<Producto> findProductosCaros();

    //obter los productos de la categoria teconologia
    @Query(value = "select p. * from productos p inner join categorias c on p.categoria_id = c.id where c.nombre = 'Tecnologia'", nativeQuery = true)
    List<Producto> findProductosDeTecnologia();

    //obteer los productos de una categoria especifica
    @Query(value = "SELECT  * FROM PRODUCTOS WHERE CATEGORIA_ID = :categoriaId", nativeQuery = true)
    List<Producto> findProductosDeUnaCategoriaEspecifica(Long categoriaId);


}

