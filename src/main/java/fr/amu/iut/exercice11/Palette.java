package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;
    private StringProperty message;
    private StringProperty couleurPanneau;

    private void EventVert(Event event){
        nbFois.set(++nbVert);
        couleurPanneau.set("#21bd2d");
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:" + couleurPanneau.get()));
    }

    private void EventRouge(Event event){
        nbFois.set(++nbRouge);
        couleurPanneau.set("#9f0000");
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:" + couleurPanneau.get()));
    }

    private void EventBleu(Event event){
        nbFois.set(++nbBleu);
        couleurPanneau.set("#52a6e1");
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:" + couleurPanneau.get()));
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        nbFois = new SimpleIntegerProperty(0);
        message = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");

        texteDuHaut = new Label("Cliquer sur un bouton");
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        texteDuHaut.textProperty().bind(message.concat("Couleur choisi ").concat(nbFois.asString().concat("fois")));
        vert.setOnAction(actionEvent -> EventVert(actionEvent) );
        rouge.setOnAction(actionEvent -> EventRouge(actionEvent) );
        bleu.setOnAction(actionEvent -> EventBleu(actionEvent) );

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

