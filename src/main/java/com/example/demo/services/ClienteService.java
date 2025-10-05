package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClienteDao;
import com.example.demo.interfaces.IClienteService;
import com.example.demo.models.Cliente;

@Service
public class ClienteService implements IClienteService {

    //inyectar las depemdencias de dao
    @Autowired
    private  ClienteDao clienteDao;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCliente'");
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDao.findAll();
    }

    @Override
    public List<Cliente> clientesMes6() {
        return clienteDao.clientesMes6();
    }

    @Override
    public Boolean actualizarCliente(Long idCliente, Cliente cliente) {
        //buscar el cliente por id
        Cliente clienteExistente=clienteDao.findById(idCliente).orElse(null);

        if(clienteExistente!=null){
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setFecha_ingreso(cliente.getFecha_ingreso());
               clienteExistente.setEmail(cliente.getEmail());
            clienteDao.save(clienteExistente);
            return true;
        }
        else{
            return false;
        }
    }
}
