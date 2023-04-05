package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.EntityMapping.*;
import com.example.databasgui_ny.dao.*;
import com.example.databasgui_ny.entities.*;
//import com.example.databasgui_ny.popGUI.UpdateController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.locationtech.jts.geom.Point;

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
    private TableColumn<InventoryEntity, Integer> inventoryIdCol = new TableColumn<>("Inventory ID");
    private TableColumn<InventoryEntity, Integer> inventoryFilmIdCol = new TableColumn<>("Film ID");
    private TableColumn<InventoryEntity, Integer> inventoryStoreIdCol = new TableColumn<>("Invetory ID");
    private TableColumn<InventoryEntity, Timestamp> inventoryLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<InventoryEntity> inventoryObList = FXCollections.observableArrayList();
    private String selectedTable;
    private final ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(menuItems);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            tableView.getColumns().clear();
            tableView.getItems().clear();
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
//                    handleFilmTable();
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
        tableView.getColumns().clear();
        tableView.getItems().clear();
        TableColumn<ActorEntity, Integer> actorIdCol = new TableColumn<>("Actor ID");
        TableColumn<ActorEntity, String> actorFirstNameCol = new TableColumn<>("First Name");
        TableColumn<ActorEntity, String> actorLastNameCol = new TableColumn<>("Last Name");
        TableColumn<ActorEntity, Date> actorLastUpdateCol = new TableColumn<>("Last Update");
        ObservableList<ActorEntity> actorObList = FXCollections.observableArrayList();
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

    public void handleAddressTable() {
        tableView.getColumns().clear();
        tableView.getItems().clear();
        TableColumn<AddressEntity, Integer> addressIdCol = new TableColumn<>("Address ID");
        TableColumn<AddressEntity, String> address1Col = new TableColumn<>("Address 1");
        TableColumn<AddressEntity, String> address2Col = new TableColumn<>("Address 2");
        TableColumn<AddressEntity, String> addressDistrictCol = new TableColumn<>("District");
        TableColumn<AddressEntity, String> addressCityIdCol = new TableColumn<>("City");
        TableColumn<AddressEntity, String> addressPostalCol = new TableColumn<>("Postal Code");
        TableColumn<AddressEntity, String> addressPhoneCol = new TableColumn<>("Phone");
        TableColumn<AddressEntity, Point> addressLocationCol = new TableColumn<>("Location");
        TableColumn<AddressEntity, Timestamp> addressLastUpdateCol = new TableColumn<>("Last Update");
        ObservableList<AddressEntity> addressObList = FXCollections.observableArrayList();
        AddressDAO addressDAO = new AddressDAO();
        addressIdCol.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        address1Col.setCellValueFactory(new PropertyValueFactory<>("address"));
        address2Col.setCellValueFactory(new PropertyValueFactory<>("address2"));
        addressDistrictCol.setCellValueFactory(new PropertyValueFactory<>("district"));
        addressPostalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        addressPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        addressLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        addressCityIdCol.setCellValueFactory(cellData -> {
            CityEntity city = cellData.getValue().getCity();
            StringProperty cityIdProp = new SimpleStringProperty(city.getCity());
            return cityIdProp;
        });
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
        tableView.getColumns().add(addressLocationCol);
        tableView.getColumns().add(addressLastUpdateCol);
    }

    public void handleCityTable() {
        tableView.getColumns().clear();
        tableView.getItems().clear();
        TableColumn<CityEntity, Integer> cityIdCol = new TableColumn<>("City ID");
        TableColumn<CityEntity, String> cityNameCol = new TableColumn<>("City");
        TableColumn<CityEntity, Integer> cityCountryIdCol = new TableColumn<>("Country Id");
        TableColumn<CityEntity, Timestamp> cityLastUpdateCol = new TableColumn<>("Last Update");
        ObservableList<CityEntity> cityObList = FXCollections.observableArrayList();
        CityDAO cityDAO = new CityDAO();
        cityIdCol.setCellValueFactory(new PropertyValueFactory<>("cityId"));
        cityNameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityCountryIdCol.setCellValueFactory(new PropertyValueFactory<>("countryId"));
        cityLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        List<CityEntity> cityList = cityDAO.readAll();
        cityObList.addAll(cityList);
        tableView.setItems(cityObList);
        tableView.getColumns().add(cityIdCol);
        tableView.getColumns().add(cityNameCol);
        tableView.getColumns().add(cityCountryIdCol);
        tableView.getColumns().add(cityLastUpdateCol);
    }

    public void handleCustomerTable() {
        tableView.getColumns().clear();
        tableView.getItems().clear();
        TableColumn<CustomerEntity, Integer> customerIdCol = new TableColumn<>("Customer ID");
        TableColumn<CustomerEntity, Integer> customerStoreIdCol = new TableColumn<>("Store ID");
        TableColumn<CustomerEntity, String> customerFirstNameCol = new TableColumn<>("First Name");
        TableColumn<CustomerEntity, String> customerLastNameCol = new TableColumn<>("Last Name");
        TableColumn<CustomerEntity, String> customerEmailCol = new TableColumn<>("E-mail");
        TableColumn<CustomerEntity, Integer> customerAddressIdCol = new TableColumn<>("Address ID");
        TableColumn<CustomerEntity, String> customerActiveCol = new TableColumn<>("Active");
        TableColumn<CustomerEntity, Timestamp> customerCreateDateCol = new TableColumn<>("Created");
        TableColumn<CustomerEntity, Timestamp> customerLastUpdateCol = new TableColumn<>("Last Update");
        ObservableList<CustomerEntity> customerObList = FXCollections.observableArrayList();
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



    public void updateButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! : " + choiceBox.getValue());
        Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();

        if (selectedActor != null) {
            int actorId = selectedActor.getActorId();
            System.out.println("Selected actor ID: " + actorId);
        } else {
            System.out.println("No actor selected.");
        };
//            tableView.setItems(filmTextObList);
//            tableView.getColumns().add(filmTextIdCol);
//            tableView.getColumns().add(filmTextTitleCol);
//            tableView.getColumns().add(filmTextDescriptionCol);
        }


    public void handleInventoryTable() {
        if (inventoryObList.size() == 0) {
            InventoryDAO inventoryDAO = new InventoryDAO();

            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
            inventoryFilmIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
            inventoryStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
            inventoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<InventoryEntity> inventoryList = inventoryDAO.readAll();
            inventoryObList.addAll(inventoryList);

            tableView.setItems(inventoryObList);
            tableView.getColumns().add(inventoryIdCol);
            tableView.getColumns().add(inventoryFilmIdCol);
            tableView.getColumns().add(inventoryStoreIdCol);
            tableView.getColumns().add(inventoryLastUpdateCol);
        }
    }
//
//    public void handlePaymentTable() {
//        if (paymentObList.size() == 0) {
//            PaymentDAO paymentDAO = new PaymentDAO();
//
//            paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
//            paymentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
//            paymentStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
//            paymentRentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
//            paymentAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
//            paymentPaymentDateCol.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
//            paymentLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<Payment> paymentList = paymentDAO.readAll();
//            paymentObList.addAll(paymentList);
//
//            tableView.setItems(paymentObList);
//            tableView.getColumns().add(paymentIdCol);
//            tableView.getColumns().add(paymentCustomerIdCol);
//            tableView.getColumns().add(paymentStaffIdCol);
//            tableView.getColumns().add(paymentRentalIdCol);
//            tableView.getColumns().add(paymentAmountCol);
//            tableView.getColumns().add(paymentPaymentDateCol);
//            tableView.getColumns().add(paymentLastUpdateCol);
//        }
//    }
//
//    public void handleRentalTable() {
//        if (rentalObList.size() == 0) {
//            RentalDAO rentalDAO = new RentalDAO();
//
//            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
//            rentalDateCol.setCellValueFactory(new PropertyValueFactory<>("rental_date"));
//            rentalInventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
//            rentalCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
//            rentalReturnDateCol.setCellValueFactory(new PropertyValueFactory<>("return_date"));
//            rentalStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
//            rentalLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<Rental> rentalList = rentalDAO.readAll();
//            rentalObList.addAll(rentalList);
//
//            tableView.setItems(rentalObList);
//            tableView.getColumns().add(rentalIdCol);
//            tableView.getColumns().add(rentalDateCol);
//            tableView.getColumns().add(rentalInventoryIdCol);
//            tableView.getColumns().add(rentalCustomerIdCol);
//            tableView.getColumns().add(rentalReturnDateCol);
//            tableView.getColumns().add(rentalStaffIdCol);
//            tableView.getColumns().add(rentalLastUpdateCol);
//        }
//    }
//
//    public void handleStaffTable() {
//        if (staffObList.size() == 0) {
//            StaffDAO staffDAO = new StaffDAO();
//
//            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
//            staffFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
//            staffLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
//            staffAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
//            staffEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
//            staffStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
//            staffActiveCol.setCellValueFactory(new PropertyValueFactory<>("active"));
//
//            List<Staff> staffList = staffDAO.readAll();
//            staffObList.addAll(staffList);
//
//            tableView.setItems(staffObList);
//            tableView.getColumns().add(staffIdCol);
//            tableView.getColumns().add(staffFirstNameCol);
//            tableView.getColumns().add(staffLastNameCol);
//            tableView.getColumns().add(staffAddressIdCol);
//            tableView.getColumns().add(staffEmailCol);
//            tableView.getColumns().add(staffStoreIdCol);
//            tableView.getColumns().add(staffActiveCol);
//        }
//    }
//
//    public void handleStoreTable() {
//        if (storeObList.size() == 0) {
//            StoreDAO storeDAO = new StoreDAO();
//
//            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
//            storeManagerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("manager_staff_id"));
//            storeAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
//            storeLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<Store> storeList = storeDAO.readAll();
//            storeObList.addAll(storeList);
//
//            tableView.setItems(storeObList);
//            tableView.getColumns().add(storeIdCol);
//            tableView.getColumns().add(storeManagerStaffIdCol);
//            tableView.getColumns().add(storeAddressIdCol);
//            tableView.getColumns().add(storeLastUpdateCol);
//        }
//    }

//    public void updateButtonClick(ActionEvent e) throws IOException {
//        if (selectedTable != null) {
//            switch (selectedTable) {
//                case "Actor":
//                    System.out.println("Actor PopUp");
//                    Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedActor != null) {
//                        int actorId = selectedActor.getActorId();
//                        System.out.println("Selected Actor ID: " + actorId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateActor.fxml";
//                            showUpdatePopup(fxmlPath,selectedActor);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Actor selected.");
//                    }
//                    break;
//                case "Address":
//                    System.out.println("Address PopUp");
//
//                    break;
//                case "City":
//                    System.out.println("City PopUp");
//                    City selectedCity = (City) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedCity != null) {
//                        int cityId = selectedCity.getCityId();
//                        System.out.println("Selected City ID: " + cityId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateCity.fxml";
//                            showUpdatePopup(fxmlPath,selectedCity);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No City selected.");
//                    }
//                    break;
//                case "Customer":
//                    System.out.println("Customer PopUp");
//                    Customer selectedCustomer = (Customer) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedCustomer != null) {
//                        int customerId = selectedCustomer.getCustomerId();
//                        System.out.println("Selected Customer ID: " + customerId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateCustomer.fxml";
//                            showUpdatePopup(fxmlPath, selectedCustomer);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Customer selected.");
//                    }
//                    break;
//                case "Film":
//                    System.out.println("Film PopUp");
//                    Film selectedFilm = (Film) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedFilm != null) {
//                        int filmId = selectedFilm.getFilmId();
//                        System.out.println("Selected Film ID: " + filmId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateFilm.fxml";
//                            showUpdatePopup(fxmlPath, selectedFilm);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Film selected.");
//                    }
//                    break;
//                case "FilmActor":
////                    FilmActorDAO filmActorDAO = new FilmActorDAO();
//                    /** Vi har ingen kopplingstabell till filmactor så vi får fundera hur vi ska göra här,
//                     * De ingår i joincolumn i film samt actor iställer för en egen tabell.
//                     */
////                    FilmActor selectedFilmActor = (FilmActor) tableView.getSelectionModel().getSelectedItem();
////                    filmActorDAO.delete(selectedFilmActor.getActor().getActor_id());
//                    System.out.println("INTE KLAR");
//                    /** Fundera vad som ska tas bort här inne egenligen **/
//                    break;
//                case "FilmCategory":
////                    FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO();
//                    /** Vi har ingen kopplingstabell till FilmCategory så vi får fundera hur vi ska göra här,
//                     * De ingår i joincolumn i film samt Category iställer för en egen tabell.
//                     */
////                    FilmCategory selectedCategory = (FilmCategory) tableView.getSelectionModel().getSelectedItem();
////                    filmCategoryDAO.delete(selectedCategory.getCategory_id());
//                    break;
//                case "FilmText":
//                    System.out.println("FilmText PopUp");
////                    FilmText selectedFilmText = (FilmText) tableView.getSelectionModel().getSelectedItem();
////                    if (selectedFilmText != null) {
////                        int filmTextId = selectedFilmText.getFilmTextId();
////                        System.out.println("Selected Film Text ID: " + filmTextId);
////                        try {
////                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateFilmText.fxml";
////                            showUpdatePopup(fxmlPath);
////                        } catch (Exception ex) {
////                            ex.printStackTrace();
////                        }
////                    } else {
////                        System.out.println("No Film Text selected.");
////                    }
//                    break;
//                case "Inventory":
//                    System.out.println("Inventory PopUp");
//                    Inventory selectedInventory = (Inventory) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedInventory != null) {
//                        int inventoryId = selectedInventory.getInventoryId();
//                        System.out.println("Selected Inventory ID: " + inventoryId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateInventory.fxml";
//                            showUpdatePopup(fxmlPath, selectedInventory);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No inventory selected.");
//                    }
//                    break;
//                case "Payment":
//                    System.out.println("Payment PopUp");
//                    Payment selectedPayment = (Payment) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedPayment != null) {
//                        int paymentId = selectedPayment.getPaymentId();
//                        System.out.println("Selected Payment ID: " + paymentId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdatePayment.fxml";
//                            showUpdatePopup(fxmlPath, selectedPayment);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Payment selected.");
//                    }
//                    break;
//                case "Rental":
//                    System.out.println("Rental PopUp");
//                    Rental selectedRental = (Rental) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedRental != null) {
//                        int rentalId = selectedRental.getRentalId();
//                        System.out.println("Selected Rental ID: " + rentalId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateRental.fxml";
//                            showUpdatePopup(fxmlPath, selectedRental);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Rental selected.");
//                    }
//                    break;
//                case "Staff":
//                    System.out.println("Staff PopUp");
//                    Staff selectedStaff = (Staff) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedStaff != null) {
//                        int staffId = selectedStaff.getStaffId();
//                        System.out.println("Selected Staff ID: " + staffId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateStaff.fxml";
//                            showUpdatePopup(fxmlPath, selectedStaff);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Staff selected.");
//                    }
//                    break;
//                case "Store":
//                    System.out.println("Store PopUp");
//                    Store selectedStore = (Store) tableView.getSelectionModel().getSelectedItem();
//                    if (selectedStore != null) {
//                        int storeId = selectedStore.getStoreId();
//                        System.out.println("Selected Store ID: " + storeId);
//                        try {
//                            String fxmlPath = "/com/example/databasgui_ny/updatePopups/UpdateStore.fxml";
//                            showUpdatePopup(fxmlPath, selectedStore);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("No Store selected.");
//                    }
//                    break;
//            }
//        }
//
//    }

    public void deleteButtonClick(ActionEvent e) {
        if (selectedTable != null) {
            switch (selectedTable) {
                case "Actor":
                    ActorDAO actorDao = new ActorDAO();
                    ActorEntity selectedActor = (ActorEntity) tableView.getSelectionModel().getSelectedItem();
                    System.out.println("DELETING ACTOR ID: " + selectedActor.getActorId());
                    actorDao.delete(selectedActor.getActorId());
                    handleActorTable();
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


//    public void showUpdatePopup(String fxmlPath, Object selectedCustomer) {
//        try {
//            Stage updateStage = new Stage();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource(fxmlPath));
//            Parent root = loader.load();
//            UpdateController updateController = loader.getController();
//            updateController.setSelectedObject(selectedCustomer);
//            Scene scene = new Scene(root);
//            updateStage.setScene(scene);
//            updateStage.show();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
