package edu.fiuba.algo3.modelo.generadorPregunta;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class LectorJson implements Lector{
    @Override
    public List<Map<String, Object>> leer(String archivo) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(archivo);
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> preguntas = gson.fromJson(reader, listType);
        reader.close();
        return preguntas;
    }
}
