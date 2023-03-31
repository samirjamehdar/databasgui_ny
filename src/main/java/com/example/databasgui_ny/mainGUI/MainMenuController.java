package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.dao.AddressDAO;
import com.example.databasgui_ny.dao.CityDAO;
import com.example.databasgui_ny.dao.CustomerDAO;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Address;
import com.example.databasgui_ny.entities.City;
import com.example.databasgui_ny.entities.Customer;
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

    private TableColumn<City, Integer> cityIdCol = new TableColumn<>("City ID");
    private TableColumn<City, String> cityNameCol = new TableColumn<>("City");
    private TableColumn<City, String> cityCountryIdCol = new TableColumn<>("Country Id");
    private TableColumn<City, Date> cityLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<City> cityObList = FXCollections.observableArrayList();

    private TableColumn<Customer, Integer> customerIdCol = new TableColumn<>("Customer ID");
    private TableColumn<Customer, Integer> customerStoreIdCol = new TableColumn<>("Store ID");
    private TableColumn<Customer, String> customerFirstNameCol = new TableColumn<>("First Name");
    private TableColumn<Customer, String> customerLastNameCol = new TableColumn<>("Last Name");
    private TableColumn<Customer, String> customerEmailCol = new TableColumn<>("E-mail");
    private TableColumn<Customer, Integer> customerAddressIdCol = new TableColumn<>("Address ID");
    private TableColumn<Customer, String> customerActiveCol = new TableColumn<>("Active");
    private TableColumn<Customer, Date> customerCreateDateCol = new TableColumn<>("Created");
    private TableColumn<Customer, Date> customerLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Customer> customerObList = FXCollections.observableArrayList();

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
                    handleAddressTable();
                    break;
                case "City":
                    selectedTable = "City";
                    handleCityTable();
                    break;
                case "Customer":
                    selectedTable = "Customer";
                    handleCustomerTable();
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

    public void handleAddressTable() {
        if (addressObList.size() == 0) {
            AddressDAO addressDAO = new AddressDAO();

            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            address1Col.setCellValueFactory(new PropertyValueFactory<>("address"));
            address2Col.setCellValueFactory(new PropertyValueFactory<>("address2"));
            addressDistrictCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            addressCityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            addressPostalCol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
            addressPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressPhoneCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            List<Address> addressList = addressDAO.readAll();
            addressObList.addAll(addressList);

            tableView.setItems(addressObList);
            tableView.getColumns().add(addressIdCol);
            tableView.getColumns().add(address1Col);
            tableView.getColumns().add(address2Col);
            tableView.getColumns().add(addressDistrictCol);
            tableView.getColumns().add(addressCityIdCol);
            tableView.getColumns().add(addressPostalCol);
            tableView.getColumns().add(addressPhoneCol);
            tableView.getColumns().add(addressLastUpdateCol);
        }
    }
    public void handleCityTable() {
        if (cityObList.size() == 0) {
            CityDAO cityDAO = new CityDAO();

            cityIdCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            cityNameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            cityCountryIdCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            cityLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            List<City> cityList = cityDAO.readAll();
            cityObList.addAll(cityList);

            tableView.setItems(cityObList);
            tableView.getColumns().add(cityIdCol);
            tableView.getColumns().add(cityNameCol);
            tableView.getColumns().add(cityCountryIdCol);
            tableView.getColumns().add(cityLastUpdateCol);
        }
    }
    public void handleCustomerTable() {
        if (customerObList.size() == 0) {
            CustomerDAO customerDAO = new CustomerDAO();

            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            customerStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            customerFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            customerLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            customerAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            customerActiveCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            customerCreateDateCol.setCellValueFactory(new PropertyValueFactory<>("create_date"));
            customerLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            List<Customer> customerList = customerDAO.readAll();
            customerObList.addAll(customerList);

            tableView.setItems(customerObList);
            tableView.getColumns().add(customerIdCol);
            tableView.getColumns().add(customerStoreIdCol);
            tableView.getColumns().add(customerFirstNameCol);
            tableView.getColumns().add(customerLastNameCol);
            tableView.getColumns().add(customerEmailCol);
            tableView.getColumns().add(customerAddressIdCol);
            tableView.getColumns().add(customerActiveCol);
            tableView.getColumns().add(customerCreateDateCol);
            tableView.getColumns().add(customerLastUpdateCol);
        }
    }

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
