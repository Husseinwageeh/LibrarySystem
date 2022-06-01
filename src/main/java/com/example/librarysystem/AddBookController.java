package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AddBookController {
    public AnchorPane BookPane;
    public void setMainpane(AnchorPane mainpane) {
        this.BookPane = mainpane;
    }
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BooksPage.fxml"));
        Parent OpenBooks= root.load();
        BooksPageController b = root.getController();
        b.setMainpane(BookPane);
        BookPane.getChildren().removeAll();
        BookPane.getChildren().setAll(OpenBooks);
    }
}
