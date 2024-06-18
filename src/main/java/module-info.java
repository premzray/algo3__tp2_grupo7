module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.graphics;
    opens edu.fiuba.algo3 to javafx.graphics;
    exports edu.fiuba.algo3;
}