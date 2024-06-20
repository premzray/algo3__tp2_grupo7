package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneradorPreguntas {

    public static List<Map<String, Object>> leerJson(String archivo) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(archivo);
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> preguntas = gson.fromJson(reader, listType);
        reader.close();
        return preguntas;
    }

    public static Pregunta crearPregunta(Map<String, Object> datosPregunta) {
        String tipo = (String) datosPregunta.get("Tipo");
        String tematica = (String) datosPregunta.get("Tema");
        String enunciado = (String) datosPregunta.get("Pregunta");
        // esto de debe guardar en algun lado
        String textoRespuesta = (String) datosPregunta.get("Texto respuesta");
        // lo mimsmo!!!!

        Respuestas respuestaCorrecta = new Respuestas();
        respuestaCorrecta.add((String) datosPregunta.get("Respuesta"));

        Respuestas respuestasPosibles = new Respuestas();
        for (int i = 1; i <= 5; i++) {
            String opcion = (String) datosPregunta.get("Opcion " + i);
            if (opcion != null) {
                respuestasPosibles.add(opcion);
            }
        }

        TipoPuntaje tipoPuntaje;
        switch (tipo) {
            case "Verdadero Falso":
            case "Verdadero Falso Simple":
                tipoPuntaje = new Clasico();
                return new VerdaderoFalso(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Verdadero Falso Penalidad":
                tipoPuntaje = new Penalidad();
                return new VerdaderoFalso(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Multiple Choice Simple":
                tipoPuntaje = new Clasico();
                return new MultipleChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Multiple Choice Puntaje Parcial":
                tipoPuntaje = new Parcial();
                return new MultipleChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Multiple Choice Penalidad":
                tipoPuntaje = new Penalidad();
                return new MultipleChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Ordered Choice":
                tipoPuntaje = new Clasico();
                return new OrderedChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            case "Group Choice":
                tipoPuntaje = new Clasico();
                return new GroupChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
            default:
                throw new IllegalArgumentException("Tipo de pregunta desconocido: " + tipo);
                //  ESTA EXCEPCION???? CLAVAMOS ALGUN SUPUESTO?
        }
    } // HAY PROBLEMAS EN EL TIPADO DE TIPO DE PUNTAJE, POR EL PARAMETRO ESPERADO!!!
    // INSTANCIAR DIRECTAMENTE LAS CLASES HIJAS? ESO DEBE ESTAR MAL, REVISAR CON EL GRUPO

    public static List<Pregunta> generarPreguntas(String archivo) {
        List<Pregunta> preguntasList = new ArrayList<>();
        try {
            List<Map<String, Object>> preguntasDatos = leerJson(archivo);
            for (Map<String, Object> datosPregunta : preguntasDatos) {
                Pregunta pregunta = crearPregunta(datosPregunta);
                preguntasList.add(pregunta);
            }
        } catch (IOException e) {
            e.printStackTrace(); // ver q es esta excepcion pq no se xd el compa chatgpt me la sugirio
            // intellij sugiere cambiarlo por un logging mas robusto
        }
        return preguntasList;
    }

    public static void main(String[] args) {
        String archivo = "preguntas.json";
        List<Pregunta> preguntas = generarPreguntas(archivo);
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }
}
