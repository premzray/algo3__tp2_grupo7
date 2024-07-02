package edu.fiuba.algo3.modelo.generadorPregunta;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class GeneradorPreguntasTp implements GeneradorPreguntas {

    private Lector lector;

    public GeneradorPreguntasTp(Lector lector){
        this.lector = lector;
    }

    public ArrayList<Pregunta> generarPreguntas(String archivo) {
        ArrayList<Pregunta> preguntasList = new ArrayList<>();
        try {
            List<Map<String, Object>> preguntasDatos = lector.leer(archivo);
            for (Map<String, Object> datosPregunta : preguntasDatos) {
                Pregunta pregunta = crearPregunta(datosPregunta);
                preguntasList.add(pregunta);
            }
        } catch (IOException e) {
            e.printStackTrace(); // ver q es esta excepcion pq no se xd el compa chatgpt me la sugirio
            // intellij sugiere cambiarlo por un logging mas robusto. PREGUNTAR MAIA
        }
        return preguntasList;
    }

    private Pregunta crearPregunta(Map<String, Object> datosPregunta) {
        String tipo = (String) datosPregunta.get("Tipo");
        String tematica = (String) datosPregunta.get("Tema");
        String textoPregunta = (String) datosPregunta.get("Pregunta");
        double id = (double) datosPregunta.get("ID");
        String textoRespuesta = (String) datosPregunta.get("Texto respuesta");

        Respuestas respuestasPosibles = new Respuestas();
        String opcionString;

        Object i = 1;
        int j = 1;
        Object opcion = (Object) datosPregunta.get("Opcion " + i);
        while(opcion != null){
            opcionString = Objects.toString(opcion);
            respuestasPosibles.add(opcionString);
            j++;
            i = j;
            opcion = (Object) datosPregunta.get("Opcion " + i);
        }

        Respuestas respuestaCorrecta = new Respuestas();
        String respuesta = ((String) datosPregunta.get("Respuesta"));
        respuesta = respuesta.replace(" ", "");
        respuesta = respuesta.replace(";", "");
        respuesta = respuesta.replace(":", "");
        respuesta = respuesta.replace(",", "");
        char[] respuestaFinal = respuesta.toCharArray();

        for(char c: respuestaFinal){
            respuestaCorrecta.add(String.valueOf(c));
        }


        switch (tipo) {
            case "Verdadero Falso":
            case "Verdadero Falso Simple":
                return Pregunta.deTipo("VERDADERO FALSO" ,respuestaCorrecta, respuestasPosibles, "CLASICO", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Verdadero Falso Penalidad":
                return Pregunta.deTipo("VERDADERO FALSO" ,respuestaCorrecta, respuestasPosibles, "PENALIDAD", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Multiple Choice Simple":
                return Pregunta.deTipo("MULTIPLE CHOICE" ,respuestaCorrecta, respuestasPosibles, "CLASICO", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Multiple Choice Puntaje Parcial":
                return Pregunta.deTipo("MULTIPLE CHOICE",respuestaCorrecta, respuestasPosibles, "PARCIAL", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Multiple Choice Penalidad":
                return Pregunta.deTipo("MULTIPLE CHOICE" ,respuestaCorrecta, respuestasPosibles, "PENALIDAD", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Ordered Choice":
            case "Ordered choice":
                return Pregunta.deTipo("ORDERED CHOICE" ,respuestaCorrecta, respuestasPosibles, "CLASICO", tematica, textoRespuesta, (int) id, textoPregunta);
            case "Group Choice":
                return Pregunta.deTipo("GROUP CHOICE" ,respuestaCorrecta, respuestasPosibles, "CLASICO", tematica, textoRespuesta, (int) id, textoPregunta);
            default:
                throw new IllegalArgumentException("Tipo de pregunta desconocido: " + tipo);
        }
    }

    public void main(String[] args) {
        String archivo = "src/main/java/edu/fiuba/algo3/modelo/preguntas.json";
        List<Pregunta> preguntas = this.generarPreguntas(archivo);
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }
}
