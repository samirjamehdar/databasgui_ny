package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.HelloApplication;
import com.example.databasgui_ny.popGUI.AddController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Sakila");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
