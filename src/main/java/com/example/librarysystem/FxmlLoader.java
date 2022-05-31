package com.example.librarysystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String Filename) {
        try {
            URL File = HelloApplication.class.getResource("/HelloControllerjavafx/" + Filename +".fxml");
            if(File==null) {
                throw new java.io.FileNotFoundException("FXML file cannot be found");
            }
            new FXMLLoader();
            view= FXMLLoader.load(File);

        } catch (Exception e) {
            System.out.println("No Page" + Filename + " please check fxmlLoader");

        }
        return view;
    }
}
