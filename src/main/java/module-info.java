module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.desktop;
    opens edu.fiuba.algo3 to javafx.graphics;
    exports edu.fiuba.algo3;
}
