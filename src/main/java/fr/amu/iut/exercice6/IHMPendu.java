package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class IHMPendu extends Application {

    private int nbVies;
    private BorderPane root;
    private Label lbNbVies;
    private Label mot;
    private Button rejouer;

    private void eventButton(Event event, Button bouton, char lettre, String motDico, ImageView image){
        if(!motDico.equals((String)this.mot.getText()) && this.nbVies > 0 && bouton.isVisible()) {
            // Recherche présence lettre
            boolean presenceLettre = false;
            for (int i = 0; i < motDico.length(); i++) {
                if (motDico.charAt(i) == lettre) {
                    presenceLettre = true;
                }
            }

            // Si présence lettre
            if (presenceLettre) {
                //Création nouveau string du label
                String newLabel = "";
                for (int i = 0; i < motDico.length(); i++) {
                    if (lettre == motDico.charAt(i)) {
                        newLabel += lettre;
                    } else if (this.mot.getText().charAt((i)) != '*') {
                        newLabel += this.mot.getText().charAt(i);
                    } else {
                        newLabel += '*';
                    }
                }
                // Modification du label + bouton mis invisible
                this.mot.setText(newLabel);
                bouton.setVisible(false);
                // Si label correspond au mot du dictionnaire : modification de l'image
                if(motDico.equals((String)this.mot.getText())){
                    image.setImage(new Image("exercice6/penduWin.png"));
                }
            // Si lettre non présente dans le mot : vie qui baisse + modification de l'image.
            } else {
                this.nbVies--;
                image.setImage(new Image("exercice6/pendu"+ this.nbVies +".png"));
                this.lbNbVies.setText("Nombre de vies : " + this.nbVies);
                bouton.setVisible(false);
            }
        }
    }

    private void eventRejouer(Event event, Stage primaryStage) throws Exception {
        primaryStage.hide();
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création du root
        this.root = new BorderPane();

        // Initialisation des variables
        this.nbVies = 7;
        this.lbNbVies = new Label("Nombre de vies : " + nbVies);
        lbNbVies.setFont(new Font("Arial", 14));

        ImageView pendu = new ImageView("exercice6/pendu7.png");

        Dico dico = new Dico();
        String motDico = dico.getMot();

        String labelProvisoire = new String();
        for(int i = 0; i < motDico.length(); i++){
            labelProvisoire += "*";
        }
        this.mot = new Label(labelProvisoire);
        this.mot.setFont(new Font("Arial", 28));

        // Fenêtre centrale
        VBox centre = new VBox();
        centre.setAlignment(Pos.CENTER);
        centre.setStyle("-fx-background-color: #a82323");

        // Conteneurs des boutons
        GridPane grid = new GridPane();

        // Boutons du jeu
        Button a = new Button("a");
        a.setVisible(true);
        a.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, a,'a',
                motDico, pendu));
        Button b = new Button("b");
        b.setVisible(true);
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, b,'b',
                motDico, pendu));
        Button c = new Button("c");
        c.setVisible(true);
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, c,'c',
                motDico, pendu));
        Button d = new Button("d");
        d.setVisible(true);
        d.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, d,'d',
                motDico, pendu));
        Button e = new Button("e");
        e.setVisible(true);
        e.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, e,'e',
                motDico, pendu));
        Button f = new Button("f");
        f.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, f,'f',
                motDico, pendu));
        Button g = new Button("g");
        g.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, g,'g',
                motDico, pendu));
        Button h = new Button("h");
        h.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, h,'h',
                motDico, pendu));
        Button i = new Button("i");
        i.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, i,'i',
                motDico, pendu));
        Button j = new Button("j");
        j.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, j,'j',
                motDico, pendu));
        Button k = new Button("k");
        k.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, k,'k',
                motDico, pendu));
        Button l = new Button("l");
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, l,'l',
                motDico, pendu));
        Button m = new Button("m");
        m.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, m,'m',
                motDico, pendu));
        Button n = new Button("n");
        n.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, n,'n',
                motDico, pendu));
        Button o = new Button("o");
        o.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, o,'o',
                motDico, pendu));
        Button p = new Button("p");
        p.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, p,'p',
                motDico, pendu));
        Button q = new Button("q");
        q.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, q,'q',
                motDico, pendu));
        Button r = new Button("r");
        r.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, r,'r',
                motDico, pendu));
        Button s = new Button("s");
        s.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, s,'s',
                motDico, pendu));
        Button t = new Button("t");
        t.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, t,'t',
                motDico, pendu));
        Button u = new Button("u");
        u.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, u,'u',
                motDico, pendu));
        Button v = new Button("v");
        v.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, v,'v',
                motDico, pendu));
        Button w = new Button("w");
        w.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, w,'w',
                motDico, pendu));
        Button x = new Button("x");
        x.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, x,'x',
                motDico, pendu));
        Button y = new Button("y");
        y.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, y,'y',
                motDico, pendu));
        Button z = new Button("z");
        z.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> eventButton(actionEvent, z,'z',
                motDico, pendu));

        grid.add(a, 2, 0);
        grid.add(e, 3, 0);
        grid.add(i, 4, 0);
        grid.add(o, 5, 0);
        grid.add(u, 6, 0);
        grid.add(y, 7, 0);
        grid.addRow(1, b, c, d, f, g, h, j, k, l, m);
        grid.addRow(2, n, p, q, r, s, t, v, w, x, z);

        grid.setAlignment(CENTER);
        grid.setVgap(10.0);
        centre.getChildren().addAll(pendu, lbNbVies, mot, grid);

        root.setCenter(centre);

        // Bas de page
        HBox bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(20.0));
        bas.setStyle("-fx-background-color: #a82323");

        this.rejouer = new Button("Rejouer");
        rejouer.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            try {
                eventRejouer(actionEvent,/*, motDico, pendu, a, b, c,
                        d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z*/primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

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
