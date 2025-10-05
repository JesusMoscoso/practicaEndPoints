package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.models.Cliente;

public interface IClienteService {
    // Métodos del servicio de Cliente
    void guardarCliente(Cliente cliente);
    Cliente obtenerClientePorId(Long id);
    void eliminarCliente(Long id);
    List<Cliente> obtenerTodosLosClientes();
    List<Cliente> clientesMes6();
    Boolean actualizarCliente(Long idCliente,Cliente cliente);

    
}
