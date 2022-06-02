package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AddBookController {
    private AnchorPane mainPane;
    public void setMainPane(AnchorPane mainPane){
        this.mainPane=mainPane;

     }
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BooksPage.fxml"));
        Parent OpenBooks= root.load();

        BooksPageController B = root.getController();
        B.setMainpane(mainPane);

        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);
    }
}
