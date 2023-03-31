package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.util.SessionFactorySingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    Button MainMenu_Update;

    @FXML
    ChoiceBox<String> MainMenu_TableChoice = new ChoiceBox();

    ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainMenu_TableChoice.setItems(menuItems);
        MainMenu_TableChoice.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Actor":
                    System.out.println("Actor is selected, refresh the table to actor values");
                    break;
                case "Address":
                    System.out.println("Address is selected, refresh the table to actor values");
                    break;
                case "City":
                    System.out.println("City is selected, refresh the table to actor values");
                    break;
                case "Customer":
                    System.out.println("Customer is selected, refresh te table to actor values");
                    break;
                case "Film":
                    System.out.println("Film is selected, refresh the table to actor values");
                    break;
                case "Film_actor":
                    System.out.println("Film_actor is selected, refresh the table to actor values");
                    break;
                case "Film_category":
                    System.out.println("Film_category is selected, refresh the table to actor values");
                    break;
                case "Film_text":
                    System.out.println("Film_text is selected, refresh the table to actor values");
                    break;
                case "Inventory":
                    System.out.println("Inventory is selected, refresh the table to actor values");
                    break;
                case "Payment":
                    System.out.println("Payment is selected, refresh the table to actor values");
                    break;
                case "Rental":
                    System.out.println("Rental is selected, refresh the table to actor values");
                    break;
                case "Staff":
                    System.out.println("Staff is selected, refresh the table to actor values");
                    break;
                case "Store":
                    System.out.println("Store is selected, refresh the table to actor values");
                    break;
            }
        });
    }


    public void refreshTableView() {
        System.out.println(MainMenu_TableChoice.getValue());
    }

    public void testButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! :D");
        String selected = MainMenu_TableChoice.getValue();
        System.out.println(selected);
    }

}
