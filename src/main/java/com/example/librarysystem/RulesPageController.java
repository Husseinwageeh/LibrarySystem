package com.example.librarysystem;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RulesPageController implements Initializable {


    public Label RulesLabel;

    @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
   Rules r= Rules.getInstance();
   RulesLabel.setText(r.getRules);


  }
}
