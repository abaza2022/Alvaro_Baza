package com.example.rodriguez_celis;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id;
    private String nombre;
    private Double precio;
    private String urImagen;

    public Producto() {}

    public Producto(String nombre, Double precio, String urImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.urImagen = urImagen;

    }
    @Exclude
    public String getId() {
        return id;
    }
    @Exclude
    public void setId(String id) {
        this.id = id;
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
    @PropertyName("url_image")
    public String getUrImagen() {
        return urImagen;
    }
    @PropertyName("url_image")
    public void setUrImagen(String urImagen) {
        this.urImagen = urImagen;
    }
}