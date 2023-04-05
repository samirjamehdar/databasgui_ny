package com.example.databasgui_ny.popGUI;

import com.example.databasgui_ny.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("adsjfbhsklfbhaskdfbasdfhasfdjbaldf");
    }

    public void confirmButtonOnClick(ActionEvent e) {
        // Get the stage associated with the confirm button
        Stage popupStage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        // Close the popup stage
        popupStage.close();

        // Get the primary stage from the start() method of the MainMenu class
        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/main-view.fxml"));
        try {
            Parent root = loader.load();
            Scene newScene = new Scene(root);

            // Set the new scene on the primary stage
            primaryStage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }





}
