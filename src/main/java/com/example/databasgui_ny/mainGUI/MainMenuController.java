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

    private TableColumn<FilmActor, Integer> filmActorId1Col = new TableColumn<>("Actor Id");
    private TableColumn<FilmActor, Integer> filmActorId2Col = new TableColumn<>("Film Id");
    private TableColumn<FilmActor, Date> filmActorLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<FilmActor> filmActorObList = FXCollections.observableArrayList();

    private TableColumn<FilmCategory, Integer> filmCategoryId1Col = new TableColumn<>("Film Id");
    private TableColumn<FilmCategory, Integer> filmCategoryId2Col = new TableColumn<>("Category Id");
    private TableColumn<FilmCategory, Date> filmCategoryLastUpdateCol = new TableColumn<>("Last Update");
    private ObservableList<FilmCategory> filmCategoryObList = FXCollections.observableArrayList();

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
                    handleFilmTable();
                    break;
                case "Film_actor":
                    selectedTable = "FilmActor";
                    handleFilmActorTable();
                    break;
                case "Film_category":
                    selectedTable = "FilmCategory";
                    handleFilmCategoryTable();
                    break;
                case "Film_text":
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
        tableView.getColumns().clear();
        if (addressObList.size() == 0) {
            AddressDAO addressDAO = new AddressDAO();

            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            address1Col.setCellValueFactory(new PropertyValueFactory<>("address"));
            address2Col.setCellValueFactory(new PropertyValueFactory<>("address2"));
            addressDistrictCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            addressCityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            addressPostalCol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
            addressPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

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

            cityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
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
        tableView.getColumns().clear();
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
    public void handleFilmTable() {
        tableView.getColumns().clear();
        if (filmObList.size() == 0) {
            FilmDAO filmDAO = new FilmDAO();

            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            filmTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            filmDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            filmReleaseYearCol.setCellValueFactory(new PropertyValueFactory<>("release_year"));
            filmLanguageIdCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            filmOriginalLanguageIdCol.setCellValueFactory(new PropertyValueFactory<>("original_language_id"));
            filmRentalDurationCol.setCellValueFactory(new PropertyValueFactory<>("rental_duration"));
            filmRentalRateCol.setCellValueFactory(new PropertyValueFactory<>("rental_rate"));
            filmLengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
            filmReplacementCostCol.setCellValueFactory(new PropertyValueFactory<>("replacement_cost"));
            filmRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
            filmSpecialFeaturesCol.setCellValueFactory(new PropertyValueFactory<>("special_features"));
            filmLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

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
    public void handleFilmActorTable() {
        tableView.getColumns().clear();
        if (filmActorObList.size() == 0) {
            FilmActorDAO filmActorDAO = new FilmActorDAO();

            filmActorId1Col.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            filmActorId2Col.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            filmActorLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            List<FilmActor> filmActorList = filmActorDAO.readAll();
            filmActorObList.addAll(filmActorList);

            tableView.setItems(filmActorObList);
            tableView.getColumns().add(filmActorId1Col);
            tableView.getColumns().add(filmActorId2Col);
            tableView.getColumns().add(filmActorLastUpdateCol);
        }
    }
    public void handleFilmCategoryTable() {
        tableView.getColumns().clear();
        if (filmCategoryObList.size() == 0) {
            FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO();

            filmCategoryId1Col.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            filmCategoryId2Col.setCellValueFactory(new PropertyValueFactory<>("category_id"));
            filmCategoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            List<FilmCategory> filmCategoryList = filmCategoryDAO.readAll();
            filmCategoryObList.addAll(filmCategoryList);

            tableView.setItems(filmCategoryObList);
            tableView.getColumns().add(filmCategoryId1Col);
            tableView.getColumns().add(filmCategoryId2Col);
            tableView.getColumns().add(filmCategoryLastUpdateCol);
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
