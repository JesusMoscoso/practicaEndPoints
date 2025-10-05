package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Factura;

public interface FacturaDao extends JpaRepository<Factura,Long> {


}
