package com.example.demo.DTOS;

import java.sql.Date;

public class FacturaDetallesDto {
    //atributos
    private Long numF;
    private Date fechaF;
    private String clienteNombre;
    private String productoNombre;
    private Integer cantidad;

    public FacturaDetallesDto(Long numF, Date fechaF, String clienteNombre, String productoNombre, Integer cantidad) {
        this.numF = numF;
        this.fechaF = fechaF;
        this.clienteNombre = clienteNombre;
        this.productoNombre = productoNombre;
        this.cantidad = cantidad;
    }

    public Long getNumF() {
        return numF;
    }

    public void setNumF(Long numF) {
        this.numF = numF;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
