module edu.fiuba.algo3 {requires javafx.controls;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.desktop;

    opens edu.fiuba.algo3 to javafx.graphics;
    opens edu.fiuba.algo3.modelo.juego;
    opens edu.fiuba.algo3.modelo.generadorPregunta;
    opens edu.fiuba.algo3.modelo.pregunta;
    opens edu.fiuba.algo3.modelo.powerup;

    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.Vista;
    opens edu.fiuba.algo3.Vista to javafx.graphics;
    opens edu.fiuba.algo3.modelo.juego.turno;
    opens edu.fiuba.algo3.modelo.juego.jugador;
    opens edu.fiuba.algo3.modelo.juego.Jugada;
}
