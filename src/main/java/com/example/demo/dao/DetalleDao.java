package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.DTOS.FacturaDetallesDto;
import com.example.demo.models.DetalleFactura;

public interface DetalleDao extends JpaRepository<DetalleFactura,Long> {
    

    //obtener el numero de factura, la fecha, el nombre del cliente, los productos que lleva 
    //y la catidad de cada uno de los productos que lleva
    @Query(value = "SELECT f.id AS id, f.fecha AS fecha, c.nombre AS cliente, " +
                   "p.nombre AS producto, d.cantidad AS cantidad " +
                   "FROM facturas f " +
                   "JOIN clientes c ON f.cliente_id = c.id " +
                   "JOIN detalle_factura d ON f.id = d.factura_id " +
                   "JOIN productos p ON d.producto_id = p.id " +
                   "ORDER BY f.id",
           nativeQuery = true)
    List<FacturaDetallesDto> facturasConDetalles();
}
