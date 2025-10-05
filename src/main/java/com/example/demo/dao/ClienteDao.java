package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    //obtener los clientes que entraron en el mes 6
    @Query(value = "SELECT * FROM clientes WHERE EXTRACT(MONTH FROM fecha_ingreso) = 6", nativeQuery = true)
    public List<Cliente> clientesMes6();

    

}
