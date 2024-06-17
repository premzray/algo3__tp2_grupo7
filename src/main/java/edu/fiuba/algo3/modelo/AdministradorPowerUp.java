package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class AdministradorPowerUp {
    ArrayList<PowerUp> ordenPowerUps;

    public AdministradorPowerUp(){
        this.ordenPowerUps = new ArrayList<PowerUp>();
        ordenPowerUps.add(new Anulador());
        ordenPowerUps.add(new Exclusividad());
        ordenPowerUps.add(new Multiplicador());
    }

    public ArrayList<Integer> resolverPowerUps(ArrayList<Integer> puntos, ArrayList<PowerUp> powerUps){
        int i=0;
        for(PowerUp powerUp: powerUps){
            for(PowerUp powerUpOrden: ordenPowerUps){
                if(powerUpOrden.getClass() == powerUp.getClass()){
                    puntos = powerUp.usar(puntos, i);
                }
            }
            i++;
        }
        return puntos;
    }
}
