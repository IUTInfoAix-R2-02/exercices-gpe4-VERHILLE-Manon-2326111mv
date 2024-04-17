package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

import static java.lang.Thread.sleep;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();

        // Création des obstacles
        Obstacle mur = new Obstacle(300, 80, 40, 320);

        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(mur);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du temps
        timer();

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, mur);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle mur) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                     j1.deplacerEnHaut();
                     break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }

            // Collision J1 et mur
            if(mur.getX() <= j1.getLayoutX()
                    && j1.getLayoutX() <= (mur.getX() + 20)
                    && j1.getLayoutY() == mur.getY()){
                j1.deplacerEnHaut();
            } else if(mur.getX() <= j1.getLayoutX()
                    && j1.getLayoutX() <= (mur.getX() + 20)
                    && j1.getLayoutY() == (mur.getY() + 300)) {
                j1.deplacerEnBas(scene.getHeight());
            } else if (mur.getY() <= j1.getLayoutY()
                    && j1.getLayoutY() <= (mur.getY() + 300)
                    && j1.getLayoutX() == mur.getX()) {
                j1.deplacerAGauche();
            } else if (mur.getY() <= j1.getLayoutY()
                    && j1.getLayoutY() <= (mur.getY() + 300)
                    && j1.getLayoutX() == (mur.getX() + 20)) {
                j1.deplacerADroite(scene.getWidth());
            }

            System.out.print(j2.getLayoutX() + "\n" + j2.getLayoutY() + "\n" );
            // Collision J2 et mur
            if(mur.getX() <= j2.getLayoutX()
                    && j2.getLayoutX() <= (mur.getX() + 20)
                    && j2.getLayoutY() == mur.getY()){
                j2.deplacerEnHaut();
            } else if(mur.getX() <= j2.getLayoutX()
                    && j2.getLayoutX() <= (mur.getX() + 20)
                    && j2.getLayoutY() == (mur.getY() + 300)) {
                j2.deplacerEnBas(scene.getHeight());
            } else if (mur.getY() <= j2.getLayoutY()
                    && j2.getLayoutY() <= (mur.getY() + 300)
                    && j2.getLayoutX() == mur.getX()) {
                j2.deplacerAGauche();
            } else if (mur.getY() <= j2.getLayoutY()
                    && j2.getLayoutY() <= (mur.getY() + 300)
                    && j2.getLayoutX() == (mur.getX() + 20)) {
                j2.deplacerADroite(scene.getWidth());
            }

            // Collision J1 et J2
            if (j1.estEnCollision(j2)){
                System.out.println("Collision....");
                System.exit(0);
            }
        });
    }

    public void timer() throws InterruptedException {
        final Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    final int max = 5;
                    final long sleepTime = 1000;
                    int value = max;
                    while (value > 0) {
                        sleep(sleepTime);
                        value --;
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        t.start();
    }
}

