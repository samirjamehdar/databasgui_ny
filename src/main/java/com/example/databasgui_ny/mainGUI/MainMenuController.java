package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.EntityMapping.ActorEntity;
import com.example.databasgui_ny.EntityMapping.AddressEntity;
import com.example.databasgui_ny.EntityMapping.CustomerEntity;
import com.example.databasgui_ny.dao.*;
import com.example.databasgui_ny.entities.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Button MainMenu_Update;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox();

    @FXML
    private TableView tableView;

    private TableColumn<ActorEntity, Integer> actorIdCol = new TableColumn<>("Actor ID");
    private TableColumn<ActorEntity, String> actorFirstNameCol = new TableColumn<>("First Name");
    private TableColumn<ActorEntity, String> actorLastNameCol = new TableColumn<>("Last Name");
    private TableColumn<ActorEntity, Date> actorLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<ActorEntity> actorObList = FXCollections.observableArrayList();

    private TableColumn<AddressEntity, Integer> addressIdCol = new TableColumn<>("Address ID");
    private TableColumn<AddressEntity, String> address1Col = new TableColumn<>("Address 1");
    private TableColumn<AddressEntity, String> address2Col = new TableColumn<>("Address 2");
    private TableColumn<AddressEntity, String> addressDistrictCol = new TableColumn<>("District");
    private TableColumn<AddressEntity, Integer> addressCityIdCol = new TableColumn<>("City ID");
    private TableColumn<AddressEntity, String> addressPostalCol = new TableColumn<>("Postal Code");
    private TableColumn<AddressEntity, String> addressPhoneCol = new TableColumn<>("Phone");
    private TableColumn<AddressEntity, Date> addressLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<AddressEntity> addressObList = FXCollections.observableArrayList();

    private TableColumn<City, Integer> cityIdCol = new TableColumn<>("City ID");
    private TableColumn<City, String> cityNameCol = new TableColumn<>("City");
    private TableColumn<City, String> cityCountryIdCol = new TableColumn<>("Country Id");
    private TableColumn<City, Date> cityLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<City> cityObList = FXCollections.observableArrayList();

    private TableColumn<CustomerEntity, Integer> customerIdCol = new TableColumn<>("Customer ID");
    private TableColumn<CustomerEntity, Integer> customerStoreIdCol = new TableColumn<>("Store ID");
    private TableColumn<CustomerEntity, String> customerFirstNameCol = new TableColumn<>("First Name");
    private TableColumn<CustomerEntity, String> customerLastNameCol = new TableColumn<>("Last Name");
    private TableColumn<CustomerEntity, String> customerEmailCol = new TableColumn<>("E-mail");
    private TableColumn<CustomerEntity, Integer> customerAddressIdCol = new TableColumn<>("Address ID");
    private TableColumn<CustomerEntity, String> customerActiveCol = new TableColumn<>("Active");
    private TableColumn<CustomerEntity, Timestamp> customerCreateDateCol = new TableColumn<>("Created");
    private TableColumn<CustomerEntity, Timestamp> customerLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<CustomerEntity> customerObList = FXCollections.observableArrayList();

    private String selectedTable;

    private final ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(menuItems);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
//            tableView.getColumns().clear();
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
                case "FilmActor":
                    selectedTable = "FilmActor";
                    System.out.println("Film_actor is selected, refresh the table to actor values");
                    break;
                case "FilmCategory":
                    selectedTable = "FilmCategory";
                    System.out.println("Film_category is selected, refresh the table to actor values");
                    break;
                case "FilmText":
                    selectedTable = "FilmText";
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
        actorIdCol.setCellValueFactory(new PropertyValueFactory<>("actorId"));
        actorFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        actorLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        List<ActorEntity> actorList = actorDAO.readAll();
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

            List<AddressEntity> addressList = addressDAO.readAll();
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
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            customerStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("storeId"));
            customerFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            customerLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            customerActiveCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            customerCreateDateCol.setCellValueFactory(new PropertyValueFactory<>("createDate"));
            customerLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
            customerAddressIdCol.setCellValueFactory(cellData -> {
                SimpleStringProperty addressId = new SimpleStringProperty();
                AddressEntity address = cellData.getValue().getAddress();
                IntegerProperty addressIdProp = new SimpleIntegerProperty(address.getAddressId());
                return addressIdProp.asObject();
            });

            List<CustomerEntity> customerList = customerDAO.readAll();
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
            int actorId = selectedActor.getActorId();
            System.out.println("Selected actor ID: " + actorId);
        } else {
            System.out.println("No actor selected.");
        };
    }

    public void deleteButtonClick(ActionEvent e) {
        if (selectedTable != null) {
            switch (selectedTable) {
                case "Actor":
                    ActorDAO actorDao = new ActorDAO();
                    ActorEntity selectedActor = (ActorEntity) tableView.getSelectionModel().getSelectedItem();
                    System.out.println("DELETING ACTOR ID: " + selectedActor.getActorId());
                    actorObList.remove(selectedActor);
                    actorDao.delete(selectedActor.getActorId());
                    break;
                case "Address":
                    AddressDAO addressDAO = new AddressDAO();
                    Address selectedAddress = (Address) tableView.getSelectionModel().getSelectedItem();
                    addressDAO.delete(selectedAddress.getAddressId());
                    break;
                case "City":
                    CityDAO cityDAO = new CityDAO();
                    City selectedCity = (City) tableView.getSelectionModel().getSelectedItem();
                    cityDAO.delete(selectedCity.getCityId());
                    break;
                case "Customer":
                    CustomerDAO customerDao = new CustomerDAO();
                    Customer selectedCustomer = (Customer) tableView.getSelectionModel().getSelectedItem();
                    customerDao.delete(selectedCustomer.getCustomerId());
                    break;
                case "Film":
                    FilmDAO filmDAO = new FilmDAO();
                    Film selectedFilm = (Film) tableView.getSelectionModel().getSelectedItem();
                    filmDAO.delete(selectedFilm.getFilmId());
                    break;
                case "FilmActor":
//                    FilmActorDAO filmActorDAO = new FilmActorDAO();
                    /** Vi har ingen kopplingstabell till filmactor så vi får fundera hur vi ska göra här,
                     * De ingår i joincolumn i film samt actor iställer för en egen tabell.
                     */
//                    FilmActor selectedFilmActor = (FilmActor) tableView.getSelectionModel().getSelectedItem();
//                    filmActorDAO.delete(selectedFilmActor.getActor().getActor_id());
                    System.out.println("INTE KLAR");
                    /** Fundera vad som ska tas bort här inne egenligen **/
                    break;
                case "FilmCategory":
//                    FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO();
                    /** Vi har ingen kopplingstabell till FilmCategory så vi får fundera hur vi ska göra här,
                     * De ingår i joincolumn i film samt Category iställer för en egen tabell.
                     */
//                    FilmCategory selectedCategory = (FilmCategory) tableView.getSelectionModel().getSelectedItem();
//                    filmCategoryDAO.delete(selectedCategory.getCategory_id());
                    break;
                case "FilmText":
                    FilmTextDAO filmTextDAO = new FilmTextDAO();
                    FilmText selectedFilmText = (FilmText) tableView.getSelectionModel().getSelectedItem();
                    System.out.println("INTE KLAR");
                    /** Fungera vad som ska tas bort här inne **/
                    break;
                case "Inventory":
                    InventoryDAO inventoryDAO = new InventoryDAO();
                    Inventory selectedInventory = (Inventory) tableView.getSelectionModel().getSelectedItem();
                    inventoryDAO.delete(selectedInventory.getInventoryId());
                    break;
                case "Payment":
                    PaymentDAO paymentDAO = new PaymentDAO();
                    Payment selectedPayment = (Payment) tableView.getSelectionModel().getSelectedItem();
                    paymentDAO.delete(selectedPayment.getPaymentId());
                    break;
                case "Rental":
                    RentalDAO rentalDAO = new RentalDAO();
                    Rental selectedRental = (Rental) tableView.getSelectionModel().getSelectedItem();
                    rentalDAO.delete(selectedRental.getRentalId());
                    break;
                case "Staff":
                    StaffDAO staffDAO = new StaffDAO();
                    Staff selectedStaff = (Staff) tableView.getSelectionModel().getSelectedItem();
                    staffDAO.delete(selectedStaff.getStaffId());
                    break;
                case "Store":
                    StoreDAO storeDAO = new StoreDAO();
                    Store selectedStore = (Store) tableView.getSelectionModel().getSelectedItem();
                    storeDAO.delete(selectedStore.getStoreId());
                    break;
            }
        }
    }

    public void addButtonClick(ActionEvent e) throws IOException {
        if (selectedTable != null) {
            switch (selectedTable) {
                case "Actor":
                    // Load the add_actor.fxml file as the new scene
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_actor.fxml"));
                        Scene newScene = new Scene(loader.load());
                        // Create a new stage for the popup dialog
                        Stage popupStage = new Stage();
                        popupStage.setScene(newScene);
                        // Set the modality of the popup stage to be APPLICATION_MODAL
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        // Show the popup stage and wait for it to be closed
                        popupStage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }

                    break;
                case "Address":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_adress.fxml"));
                        Scene newScene = new Scene(loader.load());
                        Stage popupStage = new Stage();
                        popupStage.setScene(newScene);
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        popupStage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Customer":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_customer.fxml"));
                        Scene newScene = new Scene(loader.load());
                        Stage popupStage = new Stage();
                        popupStage.setScene(newScene);
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        popupStage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }
                    break;
                case "City":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_city.fxml"));
                        Scene newScene = new Scene(loader.load());
                        Stage popupStage = new Stage();
                        popupStage.setScene(newScene);
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        popupStage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }
                    break;
                case "Film":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_film.fxml"));
                        Scene newScene = new Scene(loader.load());
                        Stage popupStage = new Stage();
                        popupStage.setScene(newScene);
                        popupStage.initModality(Modality.APPLICATION_MODAL);
                        popupStage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }
                    break;
                    case "FilmActor":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_film_actor.fxml"));
                            Scene newScene = new Scene(loader.load());
                            Stage popupStage = new Stage();
                            popupStage.setScene(newScene);
                            popupStage.initModality(Modality.APPLICATION_MODAL);
                            popupStage.showAndWait();

                        } catch (IOException ex) {
                            ex.printStackTrace();

                        }
                        break;
                        case "FilmCategory":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_film_category.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "FilmText":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_film_text.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "Inventory":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_inventory.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "Payment":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_payment.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "Rental":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_rental.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "Staff":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_staff.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                        case "Store":
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasgui_ny/addPopups/add_store.fxml"));
                                Scene newScene = new Scene(loader.load());
                                Stage popupStage = new Stage();
                                popupStage.setScene(newScene);
                                popupStage.initModality(Modality.APPLICATION_MODAL);
                                popupStage.showAndWait();

                            } catch (IOException ex) {
                                ex.printStackTrace();

                            }
                            break;
                default:
                    System.out.println("Unsupported");
                    break;
            }
        }
    }


    public void testButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! :D");
        String selected = choiceBox.getValue();
        System.out.println(selected);
    }


}
