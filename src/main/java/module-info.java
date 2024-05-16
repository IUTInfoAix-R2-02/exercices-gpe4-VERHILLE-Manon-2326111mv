module tp.intro.javafx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;

    opens fr.amu.iut.com.example.partie3 to javafx.fxml;
    exports fr.amu.iut.com.example.partie3;
}
