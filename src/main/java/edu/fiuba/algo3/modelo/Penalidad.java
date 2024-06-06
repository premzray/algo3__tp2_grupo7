package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad implements TipoPuntaje{

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta){
      return respuestaCorrecta - respuestaIncorrecta;
    }

}
