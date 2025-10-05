package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.models.Factura;

public interface IFacturaService {

    //metodos crud
    public List<Factura>obtenerTodasFacturas();
    public Factura save(Factura factura);
}
