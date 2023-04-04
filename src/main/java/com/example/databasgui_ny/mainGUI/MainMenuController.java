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


    public void handleFilmTextTable() {
        //* Vänta med den här tills vi vet hur vi ska hantera Entitien "film_text" */
        if (filmTextObList.size() == 0) {
            FilmTextDAO filmTextDAO = new FilmTextDAO();

            filmTextIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
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
        if (paymentObList.size() == 0) {
            PaymentDAO paymentDAO = new PaymentDAO();

            paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
            paymentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            paymentStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            paymentRentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
            paymentAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            paymentPaymentDateCol.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
            paymentLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

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
        if (rentalObList.size() == 0) {
            RentalDAO rentalDAO = new RentalDAO();

            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
            rentalDateCol.setCellValueFactory(new PropertyValueFactory<>("rental_date"));
            rentalInventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            rentalCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            rentalReturnDateCol.setCellValueFactory(new PropertyValueFactory<>("return_date"));
            rentalStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            rentalLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

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
        if (staffObList.size() == 0) {
            StaffDAO staffDAO = new StaffDAO();

            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
            staffFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            staffLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            staffAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            staffEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            staffStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
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
        if (storeObList.size() == 0) {
            StoreDAO storeDAO = new StoreDAO();

            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            storeManagerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("manager_staff_id"));
            storeAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            storeLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

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
