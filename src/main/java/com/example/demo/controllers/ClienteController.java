package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    //obtenr los clientes
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>>ListarClientes() {
        try {
            return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //obtener los clientes que entraron en el mes 6
    @GetMapping("/mes6")
    public ResponseEntity<List<Cliente>>clientesMayoresA6Meses(){
        try {
            return ResponseEntity.ok(clienteService.clientesMes6());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    //actualizar cliente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void>actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){ 
        try {
            Boolean actualizado=clienteService.actualizarCliente(id, cliente);
            if(actualizado){
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
}
