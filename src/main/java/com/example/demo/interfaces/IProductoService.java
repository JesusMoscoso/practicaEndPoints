package com.example.demo.interfaces;
import java.util.List;
import com.example.demo.models.Producto;

public interface IProductoService {

    //metodos para el crud
    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void deleteById(Long id);

    public Producto update(Producto producto);

    //productos con precio mayor a 60000
    public List<Producto> productosCaros();

    //productos de la categoria tecnologia
    public List<Producto> productosDeTecnologia();

    //productos de una categoria especifica
    public List<Producto> productosDeUnaCategoriaEspecifica(Long categoriaId);

    
}
