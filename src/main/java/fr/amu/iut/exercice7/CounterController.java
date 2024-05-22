package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Button decrementButton;
    @FXML
    private Button incrementButton;
    @FXML
    private Label counterLabel;
    int counter = 0;

    public void increment() {
        counter++;
        this.counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter--;
        this.counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.counterLabel.setText("0");
        System.out.println("Initializing CounterController...");
   }
}
