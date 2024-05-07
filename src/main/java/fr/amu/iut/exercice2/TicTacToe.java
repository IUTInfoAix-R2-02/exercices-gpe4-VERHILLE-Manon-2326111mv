package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Conteneur principal
        GridPane grid = new GridPane();

        // Création labels
        Label cercle1 = new Label();
        Label cercle2 = new Label();
        Label cercle3 = new Label();
        Label cercle4 = new Label();
        Label croix1 = new Label();
        Label croix2 = new Label();
        Label croix3 = new Label();
        Label vide1 = new Label();
        Label vide2 = new Label();

        ImageView imgCercle1 = new ImageView("exercice2/Rond.png");
        cercle1.setGraphic(imgCercle1);
        ImageView imgCercle2 = new ImageView("exercice2/Rond.png");
        cercle2.setGraphic(imgCercle2);
        ImageView imgCercle3 = new ImageView("exercice2/Rond.png");
        cercle3.setGraphic(imgCercle3);
        ImageView imgCercle4 = new ImageView("exercice2/Rond.png");
        cercle4.setGraphic(imgCercle4);

        ImageView imgCroix1 = new ImageView("exercice2/Croix.png");
        croix1.setGraphic(imgCroix1);
        ImageView imgCroix2 = new ImageView("exercice2/Croix.png");
        croix2.setGraphic(imgCroix2);
        ImageView imgCroix3 = new ImageView("exercice2/Croix.png");
        croix3.setGraphic(imgCroix3);

        ImageView imgVide1 = new ImageView("exercice2/Vide.png");
        vide1.setGraphic(imgVide1);
        ImageView imgVide2 = new ImageView("exercice2/Vide.png");
        vide2.setGraphic(imgVide2);

        // Ajout des éléments dans la scène
        int x = 0, y = 0, nbCercle = 4, nbCroix = 3, nbVide = 2;
        for(int i = 0; i < 9; ++i) {
            Random random = new Random();

            int nombre = random.nextInt(3);
            if ((nombre == 0 && nbCercle == 0) || (nombre == 1 && nbCroix == 0) || (nombre == 2 && nbVide == 0)) {
                --i;
                if(x == 0){
                    x = 2;
                    --y;
                } else {
                    --x;
                }
            }

            if (nombre == 0) {
                if (nbCercle == 4) {
                    grid.add(cercle1, x, y);
                } else if (nbCercle == 3) {
                    grid.add(cercle2, x, y);
                } else if (nbCercle == 2) {
                    grid.add(cercle3, x, y);
                } else if (nbCercle == 1) {
                    grid.add(cercle4, x, y);
                }
                --nbCercle;
            } else if (nombre == 1) {
                if (nbCroix == 3) {
                    grid.add(croix1, x, y);
                } else if (nbCroix == 2) {
                    grid.add(croix2, x, y);
                } else if (nbCroix == 1) {
                    grid.add(croix3, x, y);
                }
                --nbCroix;
            } else {
                if (nbVide == 2) {
                    grid.add(vide1, x, y);
                } else if (nbVide == 1) {
                    grid.add(vide2, x, y);
                }
                --nbVide;
            }

            if (x == 2) {
                x = 0;
                ++y;
            } else {
                ++x;
            }
        }

        grid.setGridLinesVisible(true);

        /*grid.addRow(0 , cercle1 , croix1, croix2);
        grid.addRow(1 , cercle2 , cercle3, cercle4);
        grid.addRow(2 , vide1 , vide2, croix3);
        */

        /*grid.add(cercle1, 0, 0);
        grid.add(croix1, 1, 0);
        grid.add(croix2, 2, 0);
        grid.add(cercle2, 0, 1);
        grid.add(cercle3, 1, 1);
        grid.add(cercle4, 2, 1);
        grid.add(vide1, 0, 2);
        grid.add(vide2, 1, 2);
        grid.add(croix3, 2, 2);*/

        // Scène
        Scene scene = new Scene(grid);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic Tac Toe");

        primaryStage.show();
    }
}

