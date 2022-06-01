package com.example.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersPageController implements Initializable {
    public Button BackAddBtn;
    public TextField AddNameTxt;
    public TextField AddPhoneTxt;
    public ChoiceBox GenderChoiceBox;
    ObservableList<String> genderTypes = FXCollections.observableArrayList("Male", "Female","Prefer not to say");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GenderChoiceBox.setItems(genderTypes);
    }
}
