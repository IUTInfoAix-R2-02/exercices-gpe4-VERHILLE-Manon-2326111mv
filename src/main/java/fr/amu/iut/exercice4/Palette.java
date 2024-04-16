package fr.amu.iut.exercice4;

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
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    private void EventVert(Event event){
        label.setText("Vert choisi " + ++nbVert + " fois");
        panneau.setStyle("-fx-background-color: #21bd2d");
    }

    private void EventRouge(Event event){
        label.setText("Rouge choisi " + ++nbRouge + " fois");
        panneau.setStyle("-fx-background-color: #9f0000");
    }

    private void EventBleu(Event event){
        label.setText("Bleu choisi " + ++nbBleu+ " fois");
        panneau.setStyle("-fx-background-color: #52a6e1");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création d'un créateur borderPane
        this.root = new BorderPane();

        // Création du label
        HBox haut = new HBox();
        haut.setAlignment(Pos.CENTER);

        this.label = new Label();

        haut.getChildren().add(label);
        root.setTop(haut);

        // Création du panneau
        this.panneau = new Pane();

        root.setCenter(panneau);

        // Création de la zone des boutons
        this.bas = new HBox();
        bas.setAlignment(Pos.CENTER);

        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");

        bas.setSpacing(10.0);
        bas.setPadding(new Insets(5.0, 10.0, 5.0, 10.0));
        bas.getChildren().addAll(vert, rouge, bleu);

        root.setBottom(bas);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> EventVert(actionEvent) );
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> EventRouge(actionEvent) );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> EventBleu(actionEvent) );

        // Création de la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}

