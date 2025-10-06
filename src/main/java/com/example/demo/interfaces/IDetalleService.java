package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.DTOS.FacturaDetallesDto;
import com.example.demo.models.DetalleFactura;

public interface IDetalleService{ 

    //metodos crud
    public DetalleFactura save(DetalleFactura detalle);

    //obtener una factura por el id
    public List<DetalleFactura>  findAll();

    //obtener las facturas con los detalles
    public List<FacturaDetallesDto> facturaDetalles();


}
