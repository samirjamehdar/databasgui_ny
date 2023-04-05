//package com.example.databasgui_ny.popGUI;
//import com.example.databasgui_ny.dao.*;
//import com.example.databasgui_ny.entities.*;
//import com.example.databasgui_ny.entities.Country;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//public class UpdateController {
//    /*Logik för UpdatePopups*/
//    private Customer selectedCustomer;
//    @FXML
//    private TextField UpdateCustomer_Firstname;
//
//    @FXML
//    private TextField UpdateCustomer_Surname;
//
//    @FXML
//    private TextField UpdateCustomer_Email;
//
//    @FXML
//    private TextField UpdateCustomer_Adress;
//
//    @FXML
//    private TextField UpdateAdress_Postal;
//
//    @FXML
//    private DatePicker UpdateCustomer_Date;
//
//    @FXML
//    private CheckBox UpdateCustomer_IsActive;
//
//    @FXML
//    private Button UpdateCustomer_ConfirmBtn;
//
//    private Actor selectedActor;
//
//    @FXML
//    private Button UpdateActor_ConfirmBtn;
//
//    @FXML
//    private TextField UpdateActor_FirstnameField;
//
//    @FXML
//    private TextField UpdateActor_SurnameField;
//
//    private City selectedCity;
//    @FXML
//    private TextField UpdateCity_City;
//    @FXML
//    private Button UpdateCity_ConfirmBtn;
//
//    private Country selectedCoutry;
//    private Film selectedFilm;
//    @FXML
//    private TextField UpdateFilm_Title;
//    @FXML
//    private TextArea UpdateFilm_Desc;
//    @FXML
//    private TextField UpdateFilm_Release;
//    @FXML
//    private TextField UpdateFilm_RentalDur;
//    @FXML
//    private TextField UpdateFilm_RentalRate;
//    @FXML
//    private TextField UpdateFilm_Length;
//    @FXML
//    private TextField UpdateFilm_RepCost;
//    @FXML
//    private ChoiceBox UpdateFilm_Features;
//    @FXML
//    private Button UpdateFilm_ConfirmBtn;
//    private FilmText selectedFilmText;
//    private Inventory selectedInventory;
//    private Language selectedLanguage;
//    private Payment selectedPayment;
//    private Rental selectedRental;
//    private Staff selectedStaff;
//    @FXML
//    private TextField UpdateStaff_Firstname;
//    @FXML
//    private TextField UpdateStaff_Surname;
//    @FXML
//    private TextField UpdateStaff_Email;
//    @FXML
//    private CheckBox UpdateStaff_IsActive;
//    @FXML
//    private TextField UpdateStaff_Username;
//    @FXML
//    private TextField UpdateStaff_Password;
//    @FXML
//    private Button UpdateStaff_ConfirmBtn;
//    private Store selectedStore;
//
//    public void setSelectedObject(Object selectedObject) {
//        if (selectedObject instanceof Customer) {
//            this.selectedCustomer = (Customer) selectedObject;
//            UpdateCustomer_Firstname.setText(selectedCustomer.getFirstName());
//            UpdateCustomer_Surname.setText(selectedCustomer.getLastName());
//            UpdateCustomer_Email.setText(selectedCustomer.getEmail());
//            UpdateCustomer_IsActive.setSelected(selectedCustomer.isActive());
//            initializeCustomer();
//        } else if (selectedObject instanceof Actor) {
//            this.selectedActor = (Actor) selectedObject;
//            UpdateActor_FirstnameField.setText(selectedActor.getFirstName());
//            UpdateActor_SurnameField.setText(selectedActor.getLastName());
//            initializeActor();
//        }
////        else if (selectedObject instanceof Address) {
////            this.selectedAddress = (Address) selectedObject;
////        }
////        else if (selectedObject instanceof Category) {
////            this.selectedCategory = (Category) selectedObject;
////        }
//        else if (selectedObject instanceof City) {
//            this.selectedCity = (City) selectedObject;
//            UpdateCity_City.setText(selectedCity.getCity());
//            initializeCity();
//        }
////        else if (selectedObject instanceof Country) {
////            this.selectedCoutry = (Country) selectedObject;
////
////        }
//        else if (selectedObject instanceof Film) {
//            this.selectedFilm = (Film) selectedObject;
//            System.out.println("Denna verkar inte fungera får upp massor med errors");
////            UpdateFilm_Title.setText(selectedFilm.getTitle());
////            UpdateFilm_Desc.setText(selectedFilm.getDescription());
////            UpdateFilm_Release.setText(selectedFilm.getReleaseYear());
////            UpdateFilm_RentalDur.setText(selectedFilm.getRentalDuration());
////            UpdateFilm_RentalRate.setText(selectedFilm.getRentalRate());
////            UpdateFilm_Length.setText(selectedFilm.getLength());
////            UpdateFilm_RepCost.setText(selectedFilm.getReplacementCost());
////            UpdateFilm_Features.setValue(selectedFilm.getSpecialFeatures());
//            initializeFilm();
//        }
////        else if (selectedObject instanceof FilmText) {
////            this.selectedFilmText = (FilmText) selectedObject;
////
////        }
////        else if (selectedObject instanceof Inventory) {
////            this.selectedInventory = (Inventory) selectedObject;
////
////        }
////        else if (selectedObject instanceof Language) {
////            this.selectedLanguage = (Language) selectedObject;
////
////        }
////        else if (selectedObject instanceof Payment) {
////            this.selectedPayment = (Payment) selectedObject;
////
////        }
////        else if (selectedObject instanceof Rental) {
////            this.selectedRental = (Rental) selectedObject;
////
////        }
//        else if (selectedObject instanceof Staff) {
//            this.selectedStaff = (Staff) selectedObject;
//            UpdateStaff_Firstname.setText(selectedStaff.getFirstName());
//            UpdateStaff_Surname.setText(selectedStaff.getLastName());
//            UpdateStaff_Email.setText(selectedStaff.getEmail());
//            UpdateStaff_IsActive.setSelected(selectedStaff.isActive());
//            UpdateStaff_Username.setText(selectedStaff.getUsername());
//            UpdateStaff_Password.setText(selectedStaff.getPassword());
//            initializeStaff();
//
//        }
////        else if (selectedObject instanceof Store) {
////            this.selectedStore = (Store) selectedObject;
////
////        }
//    }
//    @FXML
//    public void handleCustomerUpdate(ActionEvent event) {
//        CustomerDAO customerDao = new CustomerDAO();
//        selectedCustomer.setFirstName(UpdateCustomer_Firstname.getText());
//        selectedCustomer.setLastName(UpdateCustomer_Surname.getText());
//        selectedCustomer.setEmail(UpdateCustomer_Email.getText());
////        selectedCustomer.setAdress(UpdateCustomer_Adress.getText());
//        selectedCustomer.setActive(UpdateCustomer_IsActive.isSelected());
//        selectedCustomer.setLastUpdate(UpdateCustomer_Date.getValue());
//
//        customerDao.update(selectedCustomer);
//        Stage stage = (Stage) UpdateCustomer_ConfirmBtn.getScene().getWindow();
//        stage.close();
//    }
//    public void initializeCustomer() {
//        UpdateCustomer_ConfirmBtn.setOnAction(this::handleCustomerUpdate);
//    }
//    @FXML
//    public void handleActorUpdate(ActionEvent event) {
//        ActorDAO actorDao = new ActorDAO();
//        selectedActor.setFirstName(UpdateActor_FirstnameField.getText());
//        selectedActor.setLastName(UpdateActor_SurnameField.getText());
//        actorDao.update(selectedActor);
//        Stage stage = (Stage) UpdateActor_ConfirmBtn.getScene().getWindow();
//        stage.close();
//    }
//    public void initializeActor() {
//        UpdateActor_ConfirmBtn.setOnAction(this::handleActorUpdate);
//    }
//    @FXML
//    public void handleCityUpdate(ActionEvent event) {
//        CityDAO cityDao = new CityDAO();
//        selectedCity.setCity(UpdateCity_City.getText());
//        cityDao.update(selectedCity);
//        Stage stage = (Stage) UpdateCity_ConfirmBtn.getScene().getWindow();
//        stage.close();
//    }
//    public void initializeCity() {
//        UpdateCity_ConfirmBtn.setOnAction(this::handleCityUpdate);
//    }
//    @FXML
//    public void handleFilmUpdate(ActionEvent event) {
//        System.out.println("Denna verkar inte fungera får upp massor med errors");
////        FilmDAO filmDao = new FilmDAO();
////        selectedFilm.setTitle(UpdateFilm_Title.getText());
////        selectedFilm.setDescription(UpdateFilm_Desc.getText());
////        selectedFilm.setReleaseYear(UpdateFilm_Release.getText());
////        selectedFilm.setRentalDuration(UpdateFilm_RentalDur.getText());
////        selectedFilm.setRentalRate(UpdateFilm_RentalRate.getText());
////        selectedFilm.setLength(UpdateFilm_Length.getText());
////        selectedFilm.setReplacementCost(UpdateFilm_RepCost.getText());
////        selectedFilm.setSpecialFeatures(UpdateFilm_Features.getValue());
////        filmDao.update(selectedFilm);
////        Stage stage = (Stage) UpdateFilm_ConfirmBtn.getScene().getWindow();
////        stage.close();
//    }
//    public void initializeFilm() {
//        UpdateFilm_ConfirmBtn.setOnAction(this::handleFilmUpdate);
//    }
//    @FXML
//    public void handleStaffUpdate(ActionEvent event) {
//        StaffDAO staffDao = new StaffDAO();
//        selectedStaff.setFirstName(UpdateStaff_Firstname.getText());
//        selectedStaff.setLastName(UpdateStaff_Surname.getText());
//        selectedStaff.setEmail(UpdateStaff_Email.getText());
//        selectedStaff.setActive(UpdateStaff_IsActive.isSelected());
//        selectedStaff.setUsername(UpdateStaff_Username.getText());
//        selectedStaff.setPassword(UpdateStaff_Password.getText());
//        staffDao.update(selectedStaff);
//        Stage stage = (Stage) UpdateStaff_ConfirmBtn.getScene().getWindow();
//        stage.close();
//    }
//    public void initializeStaff() {
//        UpdateStaff_ConfirmBtn.setOnAction(this::handleStaffUpdate);
//    }
//
//
//
//
//}
