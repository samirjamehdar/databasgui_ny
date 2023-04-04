package com.example.databasgui_ny.mainGUI;

import com.example.databasgui_ny.dao.*;
import com.example.databasgui_ny.entities.*;
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

    private TableColumn<FilmText, Integer> filmTextIdCol = new TableColumn<>("Film ID");
    private TableColumn<FilmText, String> filmTextTitleCol = new TableColumn<>("Title");
    private TableColumn<FilmText, String> filmTextDescriptionCol = new TableColumn<>("Description");
    private ObservableList<FilmText> filmTextObList = FXCollections.observableArrayList();

    private TableColumn<Inventory, Integer> inventoryIdCol = new TableColumn<>("Inventory ID");
    private TableColumn<Inventory, Integer> inventoryFilmIdCol = new TableColumn<>("Film ID");
    private TableColumn<Inventory, Integer> inventoryStoreIdCol = new TableColumn<>("Store ID");
    private TableColumn<Inventory, Date> inventoryLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Inventory> inventoryObList = FXCollections.observableArrayList();

    private TableColumn<Payment, Integer> paymentIdCol = new TableColumn<>("Payment ID");
    private TableColumn<Payment, Integer> paymentCustomerIdCol = new TableColumn<>("Customer ID");
    private TableColumn<Payment, Integer> paymentStaffIdCol = new TableColumn<>("Staff ID");
    private TableColumn<Payment, Integer> paymentRentalIdCol = new TableColumn<>("Rental ID");
    private TableColumn<Payment, Double> paymentAmountCol = new TableColumn<>("Amount");
    private TableColumn<Payment, Date> paymentPaymentDateCol = new TableColumn<>("Payment Date");
    private TableColumn<Payment, Date> paymentLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Payment> paymentObList = FXCollections.observableArrayList();

    public TableColumn<Rental, Integer> rentalIdCol = new TableColumn<>("Rental ID");
    private TableColumn<Rental, Integer> rentalInventoryIdCol = new TableColumn<>("Inventory ID");
    private TableColumn<Rental, Integer> rentalCustomerIdCol = new TableColumn<>("Customer ID");
    private TableColumn<Rental, Date> rentalDateCol = new TableColumn<>("Rental Date");
    private TableColumn<Rental, Date> rentalReturnDateCol = new TableColumn<>("Return Date");
    private TableColumn<Rental, Integer> rentalStaffIdCol = new TableColumn<>("Staff ID");
    private TableColumn<Rental, Date> rentalLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Rental> rentalObList = FXCollections.observableArrayList();

    private TableColumn<Staff, Integer> staffIdCol = new TableColumn<>("Staff ID");
    private TableColumn<Staff, Integer> staffStoreIdCol = new TableColumn<>("Store ID");
    private TableColumn<Staff, String> staffFirstNameCol = new TableColumn<>("First Name");
    private TableColumn<Staff, String> staffLastNameCol = new TableColumn<>("Last Name");
    private TableColumn<Staff, Integer> staffAddressIdCol = new TableColumn<>("Address ID");
    private TableColumn<Staff, String> staffEmailCol = new TableColumn<>("E-mail");
    private TableColumn<Staff, Integer> staffActiveCol = new TableColumn<>("Active");
    private TableColumn<Staff, String> staffUsernameCol = new TableColumn<>("Username");
    private TableColumn<Staff, String> staffPasswordCol = new TableColumn<>("Password");
    private TableColumn<Staff, Date> staffLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Staff> staffObList = FXCollections.observableArrayList();

    private TableColumn<Store, Integer> storeIdCol = new TableColumn<>("Store ID");
    private TableColumn<Store, Integer> storeManagerStaffIdCol = new TableColumn<>("Manager Staff ID");
    private TableColumn<Store, Integer> storeAddressIdCol = new TableColumn<>("Address ID");
    private TableColumn<Store, Date> storeLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Store> storeObList = FXCollections.observableArrayList();

    private TableColumn<Film, Integer> filmIdCol = new TableColumn<>("Film ID");
    private TableColumn<Film, String> filmTitleCol = new TableColumn<>("Title");
    private TableColumn<Film, String> filmDescriptionCol = new TableColumn<>("Description");
    private TableColumn<Film, String> filmReleaseYearCol = new TableColumn<>("Release");
    private TableColumn<Film, String> filmLanguageIdCol = new TableColumn<>("Language Id");
    private TableColumn<Film, String> filmOriginalLanguageIdCol = new TableColumn<>("Original Language Id");
    private TableColumn<Film, String> filmRentalDurationCol = new TableColumn<>("Rental Duration");
    private TableColumn<Film, String> filmRentalRateCol = new TableColumn<>("Rental Rate");
    private TableColumn<Film, String> filmLengthCol = new TableColumn<>("Length");
    private TableColumn<Film, String> filmReplacementCostCol = new TableColumn<>("Replacement Cost");
    private TableColumn<Film, String> filmRatingCol = new TableColumn<>("Rating");
    private TableColumn<Film, String> filmSpecialFeaturesCol = new TableColumn<>("Special Features");
    private TableColumn<Film, Date> filmLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<Film> filmObList = FXCollections.observableArrayList();

//    private TableColumn<FilmActor, Integer> filmActorId1Col = new TableColumn<>("Actor Id");
//    private TableColumn<FilmActor, Integer> filmActorId2Col = new TableColumn<>("Film Id");
//    private TableColumn<FilmActor, Date> filmActorLastUpdateCol = new TableColumn<>("Last Update");
//    private ObservableList<FilmActor> filmActorObList = FXCollections.observableArrayList();
//
//    private TableColumn<FilmCategory, Integer> filmCategoryId1Col = new TableColumn<>("Film Id");
//    private TableColumn<FilmCategory, Integer> filmCategoryId2Col = new TableColumn<>("Category Id");
//    private TableColumn<FilmCategory, Date> filmCategoryLastUpdateCol = new TableColumn<>("Last Update");
//    private ObservableList<FilmCategory> filmCategoryObList = FXCollections.observableArrayList();

    private String selectedTable;

    private final ObservableList<String> menuItems = FXCollections.observableArrayList("Actor", "Address", "City", "Customer", "Film", "Film_actor",
                                                                "Film_category", "Film_text", "Inventory", "Payment", "Rental", "Staff", "Store");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(menuItems);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            tableView.getItems().removeAll();
            tableView.getColumns().removeAll();
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
                    handleFilmTable();
                    break;
                case "FilmActor":
                    selectedTable = "FilmActor";
//                    handleFilmActorTable();
                    System.out.println("Film_actor is selected, refresh the table to actor values");
                    break;
                case "FilmCategory":
                    selectedTable = "FilmCategory";
//                    handleFilmCategoryTable();
                    System.out.println("Film_category is selected, refresh the table to actor values");
                    break;
                case "FilmText":
                    selectedTable = "Film_text";
                    handleFilmTextTable();
                    System.out.println("Film_text is selected, refresh the table to actor values");
                    break;
                case "Inventory":
                    selectedTable = "Inventory";
                    handleInventoryTable();
                    System.out.println("Inventory is selected, refresh the table to actor values");
                    break;
                case "Payment":
                    selectedTable = "Payment";
                    handlePaymentTable();
                    System.out.println("Payment is selected, refresh the table to actor values");
                    break;
                case "Rental":
                    selectedTable = "Rental";
                    handleRentalTable();
                    System.out.println("Rental is selected, refresh the table to actor values");
                    break;
                case "Staff":
                    selectedTable = "Staff";
                    handleStaffTable();
                    System.out.println("Staff is selected, refresh the table to actor values");
                    break;
                case "Store":
                    selectedTable = "Store";
                    handleStoreTable();
                    System.out.println("Store is selected, refresh the table to actor values");
                    break;
            }
        });
    }

    public void handleActorTable() {
        tableView.getColumns().clear();
        if (actorObList.size() == 0) {
        ActorDAO actorDAO = new ActorDAO();
        actorIdCol.setCellValueFactory(new PropertyValueFactory<>("actorId"));
        actorFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        actorLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        actorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

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
        tableView.getColumns().clear();
        if (addressObList.size() == 0) {
            AddressDAO addressDAO = new AddressDAO();

            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("addressId"));
            address1Col.setCellValueFactory(new PropertyValueFactory<>("address"));
            address2Col.setCellValueFactory(new PropertyValueFactory<>("address2"));
            addressDistrictCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            addressCityIdCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            addressPostalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            addressPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

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
        tableView.getColumns().clear();
        if (cityObList.size() == 0) {
            CityDAO cityDAO = new CityDAO();

            cityIdCol.setCellValueFactory(new PropertyValueFactory<>("cityId"));
            cityNameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            cityCountryIdCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            cityLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

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
        tableView.getColumns().clear();
        if (customerObList.size() == 0) {
            CustomerDAO customerDAO = new CustomerDAO();

            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            customerStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
            customerFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            customerLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            customerAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            customerActiveCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            customerCreateDateCol.setCellValueFactory(new PropertyValueFactory<>("createDate"));
            customerLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

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
    public void handleFilmTable() {
        tableView.getColumns().clear();
        if (filmObList.size() == 0) {
            FilmDAO filmDAO = new FilmDAO();

            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("filmId"));
            filmTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            filmDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            filmReleaseYearCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
            filmLanguageIdCol.setCellValueFactory(new PropertyValueFactory<>("language"));
            filmOriginalLanguageIdCol.setCellValueFactory(new PropertyValueFactory<>("original_language_id"));
            filmRentalDurationCol.setCellValueFactory(new PropertyValueFactory<>("rentalDuration"));
            filmRentalRateCol.setCellValueFactory(new PropertyValueFactory<>("rentalRate"));
            filmLengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
            filmReplacementCostCol.setCellValueFactory(new PropertyValueFactory<>("replacementCost"));
            filmRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
            filmSpecialFeaturesCol.setCellValueFactory(new PropertyValueFactory<>("specialFeatures"));
            filmLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<Film> filmList = filmDAO.readAll();
            filmObList.addAll(filmList);

            tableView.setItems(filmObList);
            tableView.getColumns().add(filmIdCol);
            tableView.getColumns().add(filmTitleCol);
            tableView.getColumns().add(filmDescriptionCol);
            tableView.getColumns().add(filmReleaseYearCol);
            tableView.getColumns().add(filmLanguageIdCol);
            tableView.getColumns().add(filmOriginalLanguageIdCol);
            tableView.getColumns().add(filmRentalDurationCol);
            tableView.getColumns().add(filmRentalRateCol);
            tableView.getColumns().add(filmLengthCol);
            tableView.getColumns().add(filmReplacementCostCol);
            tableView.getColumns().add(filmRatingCol);
            tableView.getColumns().add(filmSpecialFeaturesCol);
            tableView.getColumns().add(filmLastUpdateCol);
        }
    }
//    public void handleFilmActorTable() {
//        tableView.getColumns().clear();
//        if (filmActorObList.size() == 0) {
//            FilmActorDAO filmActorDAO = new FilmActorDAO();
//
//            filmActorId1Col.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
//            filmActorId2Col.setCellValueFactory(new PropertyValueFactory<>("film_id"));
//            filmActorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<FilmActor> filmActorList = filmActorDAO.readAll();
//            filmActorObList.addAll(filmActorList);
//
//            tableView.setItems(filmActorObList);
//            tableView.getColumns().add(filmActorId1Col);
//            tableView.getColumns().add(filmActorId2Col);
//            tableView.getColumns().add(filmActorLastUpdateCol);
//        }
//    }
//    public void handleFilmCategoryTable() {
//        tableView.getColumns().clear();
//        if (filmCategoryObList.size() == 0) {
//            FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO();
//
//            filmCategoryId1Col.setCellValueFactory(new PropertyValueFactory<>("film_id"));
//            filmCategoryId2Col.setCellValueFactory(new PropertyValueFactory<>("category_id"));
//            filmCategoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));
//
//            List<FilmCategory> filmCategoryList = filmCategoryDAO.readAll();
//            filmCategoryObList.addAll(filmCategoryList);
//
//            tableView.setItems(filmCategoryObList);
//            tableView.getColumns().add(filmCategoryId1Col);
//            tableView.getColumns().add(filmCategoryId2Col);
//            tableView.getColumns().add(filmCategoryLastUpdateCol);
//        }
//    }


    public void handleFilmTextTable() {
        tableView.getColumns().clear();
        if (filmTextObList.size() == 0) {
            FilmTextDAO filmTextDAO = new FilmTextDAO();

            filmTextIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
            filmTextTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            filmTextDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

            List<FilmText> filmTextList = filmTextDAO.readAll();
            filmTextObList.addAll(filmTextList);

            tableView.setItems(filmTextObList);
            tableView.getColumns().add(filmTextIdCol);
            tableView.getColumns().add(filmTextTitleCol);
            tableView.getColumns().add(filmTextDescriptionCol);
        }
    }

    public void handleInventoryTable() {
        tableView.getColumns().clear();
        if (inventoryObList.size() == 0) {
            InventoryDAO inventoryDAO = new InventoryDAO();

            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
            inventoryFilmIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
            inventoryStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
            inventoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<Inventory> inventoryList = inventoryDAO.readAll();
            inventoryObList.addAll(inventoryList);

            tableView.setItems(inventoryObList);
            tableView.getColumns().add(inventoryIdCol);
            tableView.getColumns().add(inventoryFilmIdCol);
            tableView.getColumns().add(inventoryStoreIdCol);
            tableView.getColumns().add(inventoryLastUpdateCol);
        }
    }

        public void handlePaymentTable() {
            tableView.getColumns().clear();
        if (paymentObList.size() == 0) {
            PaymentDAO paymentDAO = new PaymentDAO();

            paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
            paymentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
            paymentStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff"));
            paymentRentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental"));
            paymentAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            paymentPaymentDateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
            paymentLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<Payment> paymentList = paymentDAO.readAll();
            paymentObList.addAll(paymentList);

            tableView.setItems(paymentObList);
            tableView.getColumns().add(paymentIdCol);
            tableView.getColumns().add(paymentCustomerIdCol);
            tableView.getColumns().add(paymentStaffIdCol);
            tableView.getColumns().add(paymentRentalIdCol);
            tableView.getColumns().add(paymentAmountCol);
            tableView.getColumns().add(paymentPaymentDateCol);
            tableView.getColumns().add(paymentLastUpdateCol);
        }
    }

        public void handleRentalTable() {
            tableView.getColumns().clear();
        if (rentalObList.size() == 0) {
            RentalDAO rentalDAO = new RentalDAO();

            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
            rentalDateCol.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
            rentalInventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory"));
            rentalCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
            rentalReturnDateCol.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
            rentalStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff"));
            rentalLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<Rental> rentalList = rentalDAO.readAll();
            rentalObList.addAll(rentalList);

            tableView.setItems(rentalObList);
            tableView.getColumns().add(rentalIdCol);
            tableView.getColumns().add(rentalDateCol);
            tableView.getColumns().add(rentalInventoryIdCol);
            tableView.getColumns().add(rentalCustomerIdCol);
            tableView.getColumns().add(rentalReturnDateCol);
            tableView.getColumns().add(rentalStaffIdCol);
            tableView.getColumns().add(rentalLastUpdateCol);
        }
    }

    public void handleStaffTable() {
        tableView.getColumns().clear();
        if (staffObList.size() == 0) {
            StaffDAO staffDAO = new StaffDAO();

            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
            staffFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            staffLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            staffAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            staffEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            staffStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
            staffActiveCol.setCellValueFactory(new PropertyValueFactory<>("active"));

            List<Staff> staffList = staffDAO.readAll();
            staffObList.addAll(staffList);

            tableView.setItems(staffObList);
            tableView.getColumns().add(staffIdCol);
            tableView.getColumns().add(staffFirstNameCol);
            tableView.getColumns().add(staffLastNameCol);
            tableView.getColumns().add(staffAddressIdCol);
            tableView.getColumns().add(staffEmailCol);
            tableView.getColumns().add(staffStoreIdCol);
            tableView.getColumns().add(staffActiveCol);
        }
    }

    public void handleStoreTable() {
        tableView.getColumns().clear();
        if (storeObList.size() == 0) {
            StoreDAO storeDAO = new StoreDAO();

            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("storeId"));
            storeManagerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("managerStaff"));
            storeAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            storeLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            List<Store> storeList = storeDAO.readAll();
            storeObList.addAll(storeList);

            tableView.setItems(storeObList);
            tableView.getColumns().add(storeIdCol);
            tableView.getColumns().add(storeManagerStaffIdCol);
            tableView.getColumns().add(storeAddressIdCol);
            tableView.getColumns().add(storeLastUpdateCol);
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
                    Actor selectedActor = (Actor) tableView.getSelectionModel().getSelectedItem();
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


    public void testButtonClick(ActionEvent e) {
        System.out.println("TestButton clicked! :D");
        String selected = choiceBox.getValue();
        System.out.println(selected);
    }

    public String getSelectedTable() {
        return selectedTable;
    }

}
