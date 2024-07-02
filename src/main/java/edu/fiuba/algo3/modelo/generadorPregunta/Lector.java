package edu.fiuba.algo3.modelo.generadorPregunta;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Lector {

    public static Lector crear(){
        return new LectorJson();
    }

    public List<Map<String, Object>> leer(String archivo) throws IOException;
}
