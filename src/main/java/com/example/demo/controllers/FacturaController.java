package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Factura;
import com.example.demo.services.FacturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    
    @Autowired
    private FacturaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>>obtenerFacturas() {
        try {
            List<Factura> facturas = service.obtenerTodasFacturas();
            if(facturas == null || facturas.isEmpty()){
                  return ResponseEntity.noContent().build();
            }
             return ResponseEntity.ok(facturas);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //crear una factura
    @PostMapping("/guardar")
    public ResponseEntity<Factura>crearFactura(@RequestBody Factura factura) {
        try {
            Factura nuevaFactura = service.save(factura);
            return ResponseEntity.ok(nuevaFactura);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
}
