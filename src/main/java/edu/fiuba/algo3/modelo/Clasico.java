package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Clasico implements TipoPuntaje{

    @Override
    public int puntuar(int respuestaCorrecta, int respuestaIncorrecta){
       if(respuestaIncorrecta == 0){
           return 1;
       }
        return 0;
    }
}

