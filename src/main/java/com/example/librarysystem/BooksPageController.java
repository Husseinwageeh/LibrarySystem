package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BooksPageController {
    public AnchorPane BookPane;


    public void OpenAddBook(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("AddBook.fxml"));
        Parent OpenBooks= root.load();
        MembersPageController b = root.getController();
        BookPane.getChildren().removeAll();
        BookPane.getChildren().setAll(OpenBooks);


    }

    public void RemoveBook(ActionEvent event) {
    }
}
