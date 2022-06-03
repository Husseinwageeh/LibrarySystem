package com.example.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class  BooksPageController implements Initializable {


    @FXML
    private TableView<Book> Table;


    @FXML
    private TableColumn<Book, Integer> Code;
    @FXML
    private TableColumn<Book, String> Name;
    @FXML
    private TableColumn<Book, String> Author;
    @FXML
    private TableColumn<Book, Integer> Quantity;
    @FXML
    private TableColumn<Book, String> Publisher;
    @FXML
    private TableColumn<Book, Integer> Available;
    @FXML
    private TableColumn<Book, Integer> Borrowed;
    @FXML
    private TableColumn<Book, String> Language;

    @FXML
    public AnchorPane mainpane;
    public void setMainpane(AnchorPane mainpane) {
        this.mainpane = mainpane;
    }

    public void OpenAddBook(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("AddBook.fxml"));
        Parent OpenBooks= root.load();
        AddBookController b = root.getController();
        b.setMainPane(mainpane);
        mainpane.getChildren().removeAll();
        mainpane.getChildren().setAll(OpenBooks);

    }


    public void RemoveBook(ActionEvent actionEvent) throws SQLException {
        Book b= Table.getSelectionModel().getSelectedItem();
        JDBC jdbc = JDBC.getInstance();
        jdbc.deleteBook(b);

        ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            ArrayList<Book> BooksTmp =  JDBC.getInstance().getAllBooks();
            list.addAll(BooksTmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Code.setCellValueFactory(new PropertyValueFactory<>("Book_ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Author.setCellValueFactory(new PropertyValueFactory<>("Author"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Publisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        Available.setCellValueFactory(new PropertyValueFactory<>("numAvailable"));
        Borrowed.setCellValueFactory(new PropertyValueFactory<>("numBorrowed"));
        Language.setCellValueFactory(new PropertyValueFactory<>("Language"));

        Table.setItems(list);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            ArrayList<Book> BooksTmp =  JDBC.getInstance().getAllBooks();
            list.addAll(BooksTmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Code.setCellValueFactory(new PropertyValueFactory<>("Book_ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Author.setCellValueFactory(new PropertyValueFactory<>("Author"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Publisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        Available.setCellValueFactory(new PropertyValueFactory<>("numAvailable"));
        Borrowed.setCellValueFactory(new PropertyValueFactory<>("numBorrowed"));
        Language.setCellValueFactory(new PropertyValueFactory<>("Language"));

        Table.setItems(list);


    }
}
