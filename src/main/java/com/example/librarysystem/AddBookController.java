package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class AddBookController {


    @FXML
    private TextField Name;
    @FXML
    private TextField Author;
    @FXML
    private TextField Language;
    @FXML
    private TextField Publisher;
    @FXML
    private TextField Quantity;

    @FXML
    private Button BackBookBtn;
    @FXML
    private Button AddBookBtn;





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

    public void Addbook(ActionEvent actionEvent) throws SQLException, IOException {
        String n=Name.getText(),a=Author.getText(),l=Language.getText(),p=Publisher.getText();
        int q= Integer.parseInt(Quantity.getText());
        Book b = new Book(5,n,a,l,p,q,1,1);
        JDBC jdbc=JDBC.getInstance();
        jdbc.addBook(b);
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("BooksPage.fxml"));
        Parent OpenBooks= root.load();

        BooksPageController B = root.getController();
        B.setMainpane(mainPane);

        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(OpenBooks);


    }
}
