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
import java.util.Date;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class MembersPageController implements Initializable {

    //first tab
    @FXML
    private TextField Name_Add;
    @FXML
    private TextField Phone_Add;
    @FXML
    private TextField Address_Add;
    @FXML
    private TextField National_Add;
    @FXML
    private TextField ID_Add;
    @FXML
    private ChoiceBox<String> Gender_Add;
    @FXML
    private TextField Age_Add;



    // second tab
    @FXML
    private Tab ListMembers;
    @FXML
    private TableView<Member> ListM;

    @FXML
    private TableColumn<Member, String> Name;
    @FXML
    private TableColumn<Member, String> PhoneNumber;
    @FXML
    private TableColumn<Member, String> Address;
    @FXML
    private TableColumn<Member, String> NationalID;
    @FXML
    private TableColumn<Member, Integer> Age;
    @FXML
    private TableColumn<Member, String> Gender;
    @FXML
    private TableColumn<Member, Integer> ID;
    @FXML
    Label CheckMemberRemove;
    @FXML
    Label CheckAddMember;

    @FXML
    private TabPane tab;

    @FXML
    private Tab AddTab;

    public Button BackAddBtn;

    ObservableList<String> genderTypes = FXCollections.observableArrayList("Male", "Female","Prefer not to say");
    private URL location;
    private ResourceBundle resources;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.location=location;
        this.resources=resources;

        ObservableList<Member> list = FXCollections.observableArrayList();
        try {
            ArrayList<Member> MemberTmp =  JDBC.getInstance().getAllMembers();
            list.addAll(MemberTmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Name.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        NationalID.setCellValueFactory(new PropertyValueFactory<>("NationalID"));
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        ID.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        ListM.setItems(list);
        Gender_Add.setItems(genderTypes);
    }

    public void AddMember(ActionEvent actionEvent) throws SQLException {
        Date d = new Date();
        Member m = new Member(Name_Add.getText(),Phone_Add.getText(),Address_Add.getText(),National_Add.getText(),Integer.parseInt(ID_Add.getText()),Gender_Add.getValue(),Integer.parseInt(Age_Add.getText()));
        JDBC jdbc= JDBC.getInstance();
        jdbc.addMember(m);
        initialize(location,resources);
        tab.getSelectionModel().select(ListMembers);
        CheckMemberRemove.setText("Member Added Successfully!");



    }

    public void Remove(ActionEvent actionEvent) throws SQLException {
        Member m = ListM.getSelectionModel().getSelectedItem();
        JDBC jdbc= JDBC.getInstance();
        jdbc.deleteMember(m);
        initialize(location,resources);
        tab.getSelectionModel().select(ListMembers);
        CheckMemberRemove.setText("Member Removed Successfully!");

    }
}
