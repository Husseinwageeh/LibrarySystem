package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartUpPageController {
@FXML
Button LoginBtn;
@FXML
TextField username;
@FXML
TextField password;
@FXML
CheckBox RememberCheck;
private Stage stage;
@FXML
Label IncorrectPass;
@FXML
    public void logIN (ActionEvent event) throws IOException {
    try {
        String id = username.getText();
        String Password = password.getText();
        if (id.equals("admin") && Password.equals("admin")) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
        } else if (id.equals("admin") && !password.equals("admin"))
        {
            throw new Exception("Incorrect Password, Try again");

        }
        else
        {
            throw new Exception("Enter a valid value!");

        }
    } catch (Exception e)
    {
        IncorrectPass.setText(e.getMessage());
    }
}

    public void LoginFawzy(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

    }
}
