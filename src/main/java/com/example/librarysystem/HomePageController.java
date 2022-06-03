package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

//import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{
    @FXML
    Hyperlink HyperLink1;

    public AnchorPane mainPane;

    public void exit(ActionEvent event) {
        System.exit(0);
    }


    public void OpenBooks(ActionEvent actionEvent) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BooksPage.fxml"));
        Parent OpenBooks= root.load();
        BooksPageController b = root.getController();
        b.setMainpane(mainPane);
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

    public void OpenBorrow(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BorrowBookPage.fxml"));
        Parent OpenBooks= root.load();
        BorrowBookPageController b = root.getController();
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);

    }

    public void OpenRepositry(ActionEvent event) throws URISyntaxException, IOException {
        //Desktop.getDesktop().browse(new URI("https://github.com/Husseinwageeh/LibrarySystem"));


    }

    public void OpenHome(ActionEvent event) throws IOException{
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomePageRight.fxml"));
        Parent OpenBooks= root.load();
        HomePageRightController b = root.getController();
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomePageRight.fxml"));
        Parent OpenBooks= null;
        try {
            OpenBooks = root.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);
    }
}
