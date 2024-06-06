package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Respuesta{

    private final String nombre;

    public Respuesta(){
        this.nombre = "Respuesta generica para tests";
    }

    public Respuesta(String nombre){
            this.nombre = nombre;
    }

    public String getNombre(){
        return (this.nombre);
    }

    public boolean equals(Respuesta r){
        return Objects.equals(this.nombre, r.getNombre());
    }
}