package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

import static javafx.geometry.Pos.CENTER;

public class IHMPendu extends Application {

    private int nbVies;
    private BorderPane root;
    private Label lbNbVies;
    private Label mot;
    private Button rejouer;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création du root
        this.root = new BorderPane();

        // Fenêtre centrale
        VBox centre = new VBox();
        centre.setAlignment(Pos.CENTER);
        centre.setStyle("-fx-background-color: #da9292");

        this.nbVies = 7;

        this.lbNbVies = new Label("Nombre de vies : " + nbVies);
        lbNbVies.setFont(new Font("Arial", 14));


        this.mot = new Label("******");
        mot.setFont(new Font("Arial", 28));

        // Conteneurs des boutons
        HBox voyelles = new HBox();
        voyelles.setAlignment(Pos.CENTER);
        voyelles.setStyle("-fx-background-color: #da9292");
        HBox consonnes1 = new HBox();
        consonnes1.setAlignment(Pos.CENTER);
        voyelles.setStyle("-fx-background-color: #da9292");
        HBox consonnes2 =  new HBox();
        consonnes2.setAlignment(Pos.CENTER);
        voyelles.setStyle("-fx-background-color: #da9292");

        // Boutons du jeu
        Button a = new Button("a");
        Button b = new Button("b");
        Button c = new Button("c");
        Button d = new Button("d");
        Button e = new Button("e");
        Button f = new Button("f");
        Button g = new Button("g");
        Button h = new Button("h");
        Button i = new Button("i");
        Button j = new Button("j");
        Button k = new Button("k");
        Button l = new Button("l");
        Button m = new Button("m");
        Button n = new Button("n");
        Button o = new Button("o");
        Button p = new Button("p");
        Button q = new Button("q");
        Button r = new Button("r");
        Button s = new Button("w");
        Button t = new Button("t");
        Button u = new Button("u");
        Button v = new Button("v");
        Button w = new Button("w");
        Button x = new Button("x");
        Button y = new Button("y");
        Button z = new Button("z");

        voyelles.getChildren().addAll(a, e, i, o, u, y);
        consonnes1.getChildren().addAll(b, c, d, f, g, h, j, k, l, m);
        consonnes2.getChildren().addAll(n, p, q, r, s, t, v, w, x, z);

        centre.getChildren().addAll(lbNbVies, mot, voyelles, consonnes1, consonnes2);

        root.setCenter(centre);

        // Bas de page
        HBox bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(5.0, 5.0, 5.0,5.0));
        bas.setStyle("-fx-background-color: #da9292");

        this.rejouer = new Button("Rejouer");

        bas.getChildren().addAll(rejouer);

        root.setBottom(bas);

        // Création de la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
