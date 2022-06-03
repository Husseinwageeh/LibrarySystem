package com.example.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BorrowBookPageController implements Initializable {


    @FXML
    private ChoiceBox<String> Books;
    @FXML
    private Button Borrow;
    @FXML
    private Label CheckBorrowBook;

    @FXML
    private DatePicker DateP;

    @FXML
    private ChoiceBox<String> Member;

    // table view
    @FXML
    private TableView<Member> LitsB;
    @FXML
    private TableColumn<Member,Integer > ID;
    @FXML
    private TableColumn<Member, String> Name;
    @FXML
    private TableColumn<Member, String> Phone;
    @FXML
    private TableColumn<Member, String> Address;
    @FXML
    private TableColumn<Member, String> National;
    @FXML
    private TableColumn<Member, Integer> Age;
    @FXML
    private TableColumn<Member, String> Gender;
    @FXML
    private TableColumn<Member, String> Date;
    @FXML
    private TableColumn<Member, String> Book;

    ObservableList<String> AvailableBooks = FXCollections.observableArrayList();
    ObservableList<String> Members = FXCollections.observableArrayList();
    ArrayList<Member>m = JDBC.getInstance().getAllMembers();

    private URL location;
    private ResourceBundle resources;


    public BorrowBookPageController() throws SQLException {
    }

    public void BorrowBook(ActionEvent actionEvent) throws SQLException {
        JDBC jdbc=JDBC.getInstance();
        jdbc.borrowBook(Member.getValue(),Books.getValue());
        for(Member member : m) {
            if(member.getFullName().equals(Member.getValue()))
            {
                member.setBorrowedbook(Books.getValue());
                member.setDate(DateP.getValue().toString());
            }
        }
        initialize(location,resources);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.location=location;
        this.resources=resources;


        ObservableList<Member> list = FXCollections.observableArrayList();
        try {
            ArrayList<Member> MemberTmp =  JDBC.getInstance().getAllMembers();
            list.addAll(MemberTmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        National.setCellValueFactory(new PropertyValueFactory<>("NationalID"));
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Book.setCellValueFactory(new PropertyValueFactory<>("BorrowedBook"));

        LitsB.setItems(list);

        try {
            ArrayList<Book> Tmp=JDBC.getInstance().getAvailableBooks();
            for(Book book : Tmp) {
                AvailableBooks.add(book.getTitle());
            }
            ArrayList<Member> MTmp=JDBC.getInstance().getAllMembers();
            for(Member member : MTmp) {
                Members.add(member.FullName);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        Books.setItems(AvailableBooks);
        Member.setItems(Members);
    }
}
