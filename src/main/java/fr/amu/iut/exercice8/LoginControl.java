package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

import javax.swing.text.PasswordView;
import java.awt.*;

public class LoginControl extends GridPane {

    @FXML
    private TextField uid;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.println("User Id :" + uid.getText() +"\n" + "Password"
                + pwd.getText().replaceAll(".", "*"));
    }

    @FXML
    private void cancelClicked() {
        uid.setText("");
        pwd.clear();
    }
}