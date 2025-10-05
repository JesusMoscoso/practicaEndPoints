package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FacturaDao;
import com.example.demo.interfaces.IFacturaService;
import com.example.demo.models.Factura;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private FacturaDao facturaDao;


    @Override
    public List<Factura> obtenerTodasFacturas() {
        return facturaDao.findAll();
    }

    @Override
    public Factura save(Factura factura) {
        return facturaDao.save(factura);
    }
    
}
