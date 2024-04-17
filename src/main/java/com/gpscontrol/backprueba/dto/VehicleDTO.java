package com.gpscontrol.backprueba.dto;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;
    private String marca;
    private String sucursal;
    private String aspirante;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getAspirante() {
        return aspirante;
    }

    public void setAspirante(String aspirante) {
        this.aspirante = aspirante;
    }
}
