package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTOS.FacturaDetallesDto;
import com.example.demo.models.DetalleFactura;
import com.example.demo.services.DetalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/detalles")
public class DetalleController {

    @Autowired
    private DetalleService service;
    
    //este es para obtenerlo de forma simple
    @GetMapping("/listar")
    public ResponseEntity<List<DetalleFactura>>obtenerFacturasSimples() {
        try {
            return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //guardar un detalle
    @PostMapping("/guardar")
    public ResponseEntity<DetalleFactura>Guardar(@RequestBody DetalleFactura detalle) {
      try {
        return new ResponseEntity<>(service.save(detalle),HttpStatus.OK);
      } catch (Exception e) {
        return ResponseEntity.status(500).build();
      }
    }

    //
    @GetMapping("/listaConDetalles")
    public ResponseEntity<List<FacturaDetallesDto>>obtenerFacturasConDetalles() {
      try {
        List<FacturaDetallesDto> facturas = service.facturaDetalles();
        if(facturas != null){
           return new ResponseEntity<>(facturas,HttpStatus.OK);
        }
        return ResponseEntity.status(404).build();

      } catch (Exception e) {
        return ResponseEntity.status(500).build();
      }
    }
    
    
}
