package edu.fiuba.algo3.modelo;

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

        @Override
        public boolean esBase(){
            return (nombre.equals("BASE"));
        }

}

