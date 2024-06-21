package edu.fiuba.algo3.modelo;

import java.util.Objects;

public abstract class PowerUpTp implements PowerUp{
        String nombre;

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public boolean equals(PowerUp powerUpComparado){
            return (this.getNombre().equals(powerUpComparado.getNombre()));
        }

}

