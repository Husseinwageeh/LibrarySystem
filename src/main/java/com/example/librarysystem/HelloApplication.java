package com.example.librarysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       // (new JDBC()).test();
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("StartUpPage.fxml"));
        Scene scene = new Scene(root.load());
        stage.setTitle("AAST LIBRARY");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}