package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Respuestas {

    private final ArrayList<String> respuestas;

    public Respuestas(){
        this.respuestas = new ArrayList<String>();
    }//usado

    private boolean equals(Respuestas r, int i){ return (this.get(i).equals(r.get(i)));} //usado

    private boolean equals(Respuestas r){
        return Objects.equals(this, r);
    } //usado

    private boolean equals(String r, int i) { return Objects.equals(this.get(i), r); }

    public boolean contains(String s){ return (this.respuestas.contains(s));}

    //desde aca usa el codigo

    public String get(int i){ return this.respuestas.get(i);} //usado

    public void add(String r){ this.respuestas.add(r); } //usado

    public int size(){ return this.respuestas.size();} //usado

    public boolean equalSize(Respuestas r) { return (this.size() == r.size());} //usado

    public boolean esMayorQue(Respuestas r) { return (this.size() > r.size());}

    public int cuantasIguales(Respuestas r){
        int cont = 0;

        for(int i = 0 ;i < this.size(); i++){
            if(this.equals(r, i)){
                cont++;
            }
        }

        return cont;
    }

    public int cuantasDiferentes(Respuestas r){
        int cont = 0;

        for(int i = 0 ;i < r.size(); i++){
            if(!this.equals(r, i)){
                cont++;
            }
        }

        return cont;
    }

    public int cuantasContiene(Respuestas r){
        int cont = 0;

        for(int i = 0; i < this.size(); i++){
            if(r.contains(this.get(i))){
                cont++;
            }
        }

        return cont;
    }

    public int cuantasNoContiene(Respuestas r){
        int cont = 0;

        for(int i = 0; i < this.size(); i++){
            if(!r.contains(this.get(i))){
                cont++;
            }
        }

        return cont;
    }
}