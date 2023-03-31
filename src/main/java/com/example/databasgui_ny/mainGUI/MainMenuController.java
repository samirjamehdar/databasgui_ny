package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Address;
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

    private TableColumn<Address, Integer> addressIdCol = new TableColumn<>("Address ID");
    private TableColumn<Address, String> address1Col = new TableColumn<>("Address 1");
    private TableColumn<Address, String> address2Col = new TableColumn<>("Address 2");
    private TableColumn<Address, String> addressDistrictCol = new TableColumn<>("District");
    private TableColumn<Address, Integer> addressCityIdCol = new TableColumn<>("City ID");
    private TableColumn<Address, String> addressPostalCol = new TableColumn<>("Postal Code");
    private TableColumn<Address, String> addressPhoneCol = new TableColumn<>("Phone");
    private TableColumn<Address, Date> addressLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Address> addressObList = FXCollections.observableArrayList();

    private String selectedTable;

    private final ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(menuItems);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Actor":
                    selectedTable = "Actor";
                    handleActorTable();
                    break;
                case "Address":
                    selectedTable = "Address";
                    System.out.println("Address is selected, refresh the table to actor values");
                    break;
                case "City":
                    selectedTable = "City";
                    System.out.println("City is selected, refresh the table to actor values");
                    break;
                case "Customer":
                    selectedTable = "Customer";
                    System.out.println("Customer is selected, refresh te table to actor values");
                    break;
                case "Film":
                    selectedTable = "Film";
                    System.out.println("Film is selected, refresh the table to actor values");
                    break;
                case "Film_actor":
                    selectedTable = "Film_actor";
                    System.out.println("Film_actor is selected, refresh the table to actor values");
                    break;
                case "Film_category":
                    selectedTable = "Film_category";
                    System.out.println("Film_category is selected, refresh the table to actor values");
                    break;
                case "Film_text":
                    selectedTable = "Film_text";
                    System.out.println("Film_text is selected, refresh the table to actor values");
                    break;
                case "Inventory":
                    selectedTable = "Inventory";
                    System.out.println("Inventory is selected, refresh the table to actor values");
                    break;
                case "Payment":
                    selectedTable = "Payment";
                    System.out.println("Payment is selected, refresh the table to actor values");
                    break;
                case "Rental":
                    selectedTable = "Rental";
                    System.out.println("Rental is selected, refresh the table to actor values");
                    break;
                case "Staff":
                    selectedTable = "Staff";
                    System.out.println("Staff is selected, refresh the table to actor values");
                    break;
                case "Store":
                    selectedTable = "Staff";
                    System.out.println("Store is selected, refresh the table to actor values");
                    break;
            }
        });
    }

    public void handleActorTable() {
        if (actorObList.size() == 0) {
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
    }

//    public void handleAddressTable() {
//        if (addressObList.size() == 0) {
//            AddressDAO addressDAO = new AddressDAO();
//
//            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
//            actorFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
//            actorLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
//            actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//            actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//            actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//            actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//            actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<Actor> actorList = actorDAO.readAll();
//            actorObList.addAll(actorList);
//
//            tableView.setItems(actorObList);
//            tableView.getColumns().add(actorIdCol);
//            tableView.getColumns().add(actorFirstNameCol);
//            tableView.getColumns().add(actorLastNameCol);
//            tableView.getColumns().add(actorLastUpdateCol);
//        }
//    }

    public void updateButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! : " + choiceBox.getValue());
        Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();

        if (selectedActor != null) {
            int actorId = selectedActor.getActor_id();
            System.out.println("Selected actor ID: " + actorId);
        } else {
            System.out.println("No actor selected.");
        };
    }

    public void deleteButtonClick(ActionEvent e) {
        switch (selectedTable) {
            case "Actor":
                ActorDAO actorDao = new ActorDAO();
                Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();
                System.out.println("DELETING ACTOR ID: " + selectedActor.getActor_id());
                actorDao.delete(selectedActor.getActor_id());
        }

//        Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();

//        if (selectedActor != null) {
//            int actorId = selectedActor.getActor_id();
//            System.out.println("Selected actor ID: " + actorId);
//        } else {
//            System.out.println("No actor selected.");
//        };
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
