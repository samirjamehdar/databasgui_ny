package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.entities.Actor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Button MainMenu_Update;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox();

    @FXML
    private TableView tableView;

    private TableColumn<Actor, Integer> actorIdCol = new TableColumn<>("Actor ID");
    private TableColumn<Actor, String> actorFirstNameCol = new TableColumn<>("First Name");
    private TableColumn<Actor, String> actorLastNameCol = new TableColumn<>("Last Name");
    private TableColumn<Actor, Date> actorLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Actor> actorObList = FXCollections.observableArrayList();

    private final ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(menuItems);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Actor":
                    System.out.println("Actor is selected, refresh the table to actor values");
                    handleActorTable();
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

    public void handleActorTable() {
        System.out.println("Fungerar");
        ActorDAO actorDAO = new ActorDAO();

        actorIdCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
        actorFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        actorLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
        List<Actor> actorList = actorDAO.readAll();
        actorObList.addAll(actorList);
        tableView.setItems(actorObList);

        tableView.getColumns().add(actorIdCol);
        tableView.getColumns().add(actorFirstNameCol);
        tableView.getColumns().add(actorLastNameCol);
        tableView.getColumns().add(actorLastUpdateCol);
    }




    public void refreshTableView() {
        System.out.println(choiceBox.getValue());
    }


    public void testButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! :D");
        String selected = choiceBox.getValue();
        System.out.println(selected);
    }

}
