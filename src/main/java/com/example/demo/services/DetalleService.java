package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOS.FacturaDetallesDto;
import com.example.demo.dao.DetalleDao;
import com.example.demo.interfaces.IDetalleService;
import com.example.demo.models.DetalleFactura;

@Service
public class DetalleService implements IDetalleService {

    @Autowired
    private DetalleDao detalleDao;

    @Override
    public DetalleFactura save(DetalleFactura detalle) {
       return detalleDao.save(detalle);
    }

    @Override
    public List<DetalleFactura> findAll() {
        return detalleDao.findAll();
    }

    @Override
    public List<FacturaDetallesDto> facturaDetalles() {
        return detalleDao.facturasConDetalles();
    }
    
}
