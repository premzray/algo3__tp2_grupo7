package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuestas {

    private ArrayList<String> respuestas;

    public Respuestas(){
        this.respuestas = new ArrayList<String>();
    }//usado

    private boolean equals(Respuestas r, int i){ return (this.get(i).equals(r.get(i)));}

    private boolean contains(String s){ return (this.respuestas.contains(s));}

    public String get(int i){ return this.respuestas.get(i);}

    public void add(String r){ this.respuestas.add(r); } //LO USA LA VISUAL

    public void add(ArrayList<String> r){
        this.respuestas = r;
    }

    public int size(){ return this.respuestas.size();}

    public boolean equalSize(Respuestas r) { return (this.size() == r.size());}

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