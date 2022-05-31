package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HomePageController {
    public AnchorPane mainPane;

    public void exit(ActionEvent event) {
        System.exit(0);
    }

    public void OpenBooks(ActionEvent actionEvent) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BooksPage.fxml"));
        Parent OpenBooks= root.load();
        BooksPageController b = root.getController();
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);


    }

    public void OpenMembers(ActionEvent actionEvent) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("MembersPage.fxml"));
        Parent OpenBooks= root.load();
        MembersPageController b = root.getController();
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);
    }

    public void OpenRules(ActionEvent actionEvent) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("RulesPage.fxml"));
        Parent OpenBooks= root.load();
        RulesPageController b = root.getController();
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);
    }

}
