package edu.fiuba.algo3.modelo;

import java.util.Objects;

public abstract class PowerUpTp implements PowerUp{
        String nombre;

        public  PowerUpTp(String nombre){
            this.nombre = nombre;
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public boolean equals(PowerUp powerUpComparado){
            return (Objects.equals(this.getNombre(), powerUpComparado.getNombre()));
        }
    }
}
