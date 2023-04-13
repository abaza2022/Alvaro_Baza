package com.example.rodriguez_celis;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private Double precio;
    private String urImagen;

    public Producto() {
    }

    public Producto(String nombre, Double precio, String urImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.urImagen = urImagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrImagen() {
        return urImagen;
    }

    public void setUrImagen(String urImagen) {
        this.urImagen = urImagen;
    }
}