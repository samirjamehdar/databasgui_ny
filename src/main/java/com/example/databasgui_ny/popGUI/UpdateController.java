package com.example.databasgui_ny.popGUI;
import com.example.databasgui_ny.EntityMapping.*;
import com.example.databasgui_ny.dao.*;
import com.example.databasgui_ny.entities.*;
import com.example.databasgui_ny.entities.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Timestamp;

public class UpdateController {
    /*Logik för UpdatePopups*/
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
    private Inventory selectedInventory;
    private Language selectedLanguage;

    private PaymentEntity selectedPayment;
    @FXML
    private TextField Payment_CustomerID;
    @FXML
    private TextField Payment_StaffID;
    @FXML
    private TextField Payment_RentalID;
    @FXML
    private TextField amountField;
    @FXML
    private DatePicker payDate_Box;
    @FXML
    private Button Payments_ConfirmBtn;

    private Rental selectedRental;
    private Staff selectedStaff;
    @FXML
    private TextField UpdateStaff_Firstname;
    @FXML
    private TextField UpdateStaff_Surname;
    @FXML
    private TextField UpdateStaff_Email;
    @FXML
    private CheckBox UpdateStaff_IsActive;
    @FXML
    private TextField UpdateStaff_Username;
    @FXML
    private TextField UpdateStaff_Password;
    @FXML
    private Button UpdateStaff_ConfirmBtn;
    private Store selectedStore;
    private ActorEntity selectedActor;
    @FXML
    private TextField actorFirstnameField;
    @FXML
    private TextField actorSurnameField;
    @FXML
    private Button actorConfirmBtn;

    private CustomerEntity selectedCustomer;
    @FXML
    private TextField customerFirstNameField;
    @FXML
    private TextField customerLastNameField;
    @FXML
    private TextField customerEMailField;
    @FXML
    private TextField customerAddress1Field;
    @FXML
    private TextField customerAddress2Field;
    @FXML
    private TextField customerPostalField;
    @FXML
    private TextField customerPhoneField;
    @FXML
    private TextField customerDistrictField;
    @FXML
    private TextField customerCityNameField;
    @FXML
    private TextField customerCountryIdField;
    @FXML
    private Button customer_ConfirmBtn;
    private FilmEntity selectedFilmEntity;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea descArea;
    @FXML
    private TextField releaseField;
    @FXML
    private TextField rentalDurField;
    @FXML
    private TextField rentalRateField;
    @FXML
    private TextField lengthField;
    @FXML
    private TextField repCostField;
    @FXML
    private CheckBox featureBox;
    @FXML
    private CheckBox ratingBox;
    @FXML
    private Button Film_ConfirmBtn;

    private StaffEntity selectedStaffEntity;
    @FXML
    private TextField Staff_Firstname;
    @FXML
    private TextField Staff_Lastname;
    @FXML
    private TextField Staff_Email;
    @FXML
    private CheckBox Staff_IsActive;
    @FXML
    private TextField Staff_Username;
    @FXML
    private TextField Staff_Password;
    @FXML
    private TextField Staff_address1Field;
    @FXML
    private TextField Staff_address2Field;
    @FXML
    private TextField Staff_PostalField;
    @FXML
    private TextField Staff_PhoneField;
    @FXML
    private TextField Staff_DistrictField;
    @FXML
    private TextField Staff_CityNameField;
    @FXML
    private TextField Staff_CountryIdField;
    @FXML
    private TextField Staff_Store;
    @FXML
    private TextField Staff_Picture;
    @FXML
    private Button Staff_ConfirmBtn;

    String countryString;


    public void setSelectedObject(Object selectedObject) {

        if (selectedObject instanceof CustomerEntity) {
            this.selectedCustomer = (CustomerEntity) selectedObject;
            CustomerDAO customerDAO = new CustomerDAO();
            CustomerEntity customerEntity = customerDAO.read(selectedCustomer.getCustomerId());
            customerFirstNameField.setText(customerEntity.getFirstName());
            customerLastNameField.setText(customerEntity.getLastName());
            customerEMailField.setText(customerEntity.getEmail());

            AddressDAO addressDao = new AddressDAO();
            AddressEntity addressEntity = addressDao.read(customerEntity.getAddressId());
            customerAddress1Field.setText(addressEntity.getAddress());
            customerAddress2Field.setText(addressEntity.getAddress2());
            customerPostalField.setText(addressEntity.getPostalCode());
            customerPhoneField.setText(addressEntity.getPhone());
            customerDistrictField.setText(addressEntity.getDistrict());

            CityDAO cityDao = new CityDAO();
            CityEntity cityEntity = cityDao.read(addressEntity.getCityId());
            customerCityNameField.setText(cityEntity.getCity());
            countryString = Integer.toString(cityEntity.getCountryId());
            customerCountryIdField.setText(countryString);

            initializeCustomer();
        }
        else if (selectedObject instanceof ActorEntity) {
            this.selectedActor = (ActorEntity) selectedObject;
            actorFirstnameField.setText(selectedActor.getFirstName());
            actorSurnameField.setText(selectedActor.getLastName());
            initializeActor();
        }
//        else if (selectedObject instanceof Category) {
//            this.selectedCategory = (Category) selectedObject;
//        }
        else if (selectedObject instanceof FilmEntity) {
            this.selectedFilmEntity = (FilmEntity) selectedObject;
            titleField.setText(selectedFilmEntity.getTitle());
            descArea.setText(selectedFilmEntity.getDescription());
            releaseField.setText(String.valueOf(selectedFilmEntity.getReleaseYear()));
            rentalDurField.setText(String.valueOf(selectedFilmEntity.getRentalDuration()));
            rentalRateField.setText(String.valueOf(selectedFilmEntity.getRentalRate()));
            lengthField.setText(String.valueOf(selectedFilmEntity.getLength()));
            repCostField.setText(String.valueOf(selectedFilmEntity.getReplacementCost()));
//            ratingBox.setSelected(selectedFilmEntity.getRating());
//            featureBox.setSelected(selectedFilmEntity.getSpecialFeatures());
            initializeFilm();
        }
//        else if (selectedObject instanceof Inventory) {
//            this.selectedInventory = (Inventory) selectedObject;
//
//        }
        else if (selectedObject instanceof PaymentEntity) {
            this.selectedPayment = (PaymentEntity) selectedObject;
            PaymentDAO paymentDAO = new PaymentDAO();
            PaymentEntity payment = paymentDAO.read(selectedPayment.getPaymentId());
            amountField.setText(String.valueOf(payment.getAmount()));
            payDate_Box.setValue(payment.getPaymentDate());

            CustomerDAO customerDAO = new CustomerDAO();
            CustomerEntity customer = customerDAO.read(payment.getCustomerId());
            Payment_CustomerID.setText(String.valueOf(customer.getCustomerId()));

            StaffDAO staffDAO = new StaffDAO();
            StaffEntity staff = staffDAO.read(payment.getStaffId());
            Payment_StaffID.setText(String.valueOf(staff.getStaffId()));

            RentalDAO rentalDAO = new RentalDAO();
            RentalEntity rental = rentalDAO.read(payment.getRentalId());
            Payment_RentalID.setText(String.valueOf(rental.getRentalId()));
            initializePayment();
        }
//        else if (selectedObject instanceof Rental) {
//            this.selectedRental = (Rental) selectedObject;
//
//        }
        else if (selectedObject instanceof StaffEntity) {
            this.selectedStaffEntity = (StaffEntity) selectedObject;
            StaffDAO staffDao = new StaffDAO();
            StaffEntity staffEntity = staffDao.read(selectedStaffEntity.getStaffId());
            Staff_Firstname.setText(staffEntity.getFirstName());
            Staff_Lastname.setText(staffEntity.getLastName());
            Staff_Email.setText(staffEntity.getEmail());
            Staff_IsActive.setSelected(staffEntity.getActive());
            Staff_Username.setText(staffEntity.getUsername());
            Staff_Password.setText(staffEntity.getPassword());
            Staff_Picture.setText(staffEntity.getPicture());

            StoreDAO storeDao = new StoreDAO();
            StoreEntity storeEntity = storeDao.read(staffEntity.getStoreId());
            Staff_Store.setText(String.valueOf(storeEntity.getStoreId()));


            AddressDAO addressDao = new AddressDAO();
            AddressEntity addressEntity = addressDao.read(staffEntity.getAddressId());
            Staff_DistrictField.setText(addressEntity.getDistrict());
            Staff_address1Field.setText(addressEntity.getAddress());
            Staff_address2Field.setText(addressEntity.getAddress2());
            Staff_PostalField.setText(addressEntity.getPostalCode());
            Staff_PhoneField.setText(addressEntity.getPhone());

            CityDAO cityDao = new CityDAO();
            CityEntity cityEntity = cityDao.read(addressEntity.getCityId());
            Staff_CityNameField.setText(cityEntity.getCity());
            countryString = Integer.toString(cityEntity.getCountryId());
            Staff_CountryIdField.setText(countryString);

            initializeStaff();
        }
//        else if (selectedObject instanceof Store) {
//            this.selectedStore = (Store) selectedObject;
//
//        }
    }
    @FXML
    public void handleCustomerUpdate(ActionEvent event) {
        CustomerDAO customerDao = new CustomerDAO();
        selectedCustomer.setFirstName(customerFirstNameField.getText());
        selectedCustomer.setLastName(customerLastNameField.getText());
        selectedCustomer.setEmail(customerEMailField.getText());
        selectedCustomer.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        AddressDAO addressDao = new AddressDAO();
        AddressEntity address = addressDao.read(selectedCustomer.getAddressId());
        address.setAddress(customerAddress1Field.getText());
        address.setAddress2(customerAddress2Field.getText());
        address.setPostalCode(customerPostalField.getText());
        address.setPhone(customerPhoneField.getText());
        address.setDistrict(customerDistrictField.getText());
        address.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        CityDAO cityDao = new CityDAO();
        CityEntity city = cityDao.read(address.getCityId());
        city.setCity(customerCityNameField.getText());
        countryString = Integer.toString(city.getCountryId());
        city.setCountryId(Integer.parseInt(countryString));
        city.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        address.setCity(city);
        selectedCustomer.setAddress(address);

        cityDao.update(city);
        addressDao.update(address);
        customerDao.update(selectedCustomer);
        Stage stage = (Stage) customer_ConfirmBtn.getScene().getWindow();
        stage.close();
    }
    public void initializeCustomer() {
        customer_ConfirmBtn.setOnAction(this::handleCustomerUpdate);
    }
    @FXML
    public void handleActorUpdate(ActionEvent event) {
        ActorDAO actorDao = new ActorDAO();
        selectedActor.setFirstName(actorFirstnameField.getText());
        selectedActor.setLastName(actorSurnameField.getText());
        selectedActor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        actorDao.update(selectedActor);
        Stage stage = (Stage) actorConfirmBtn.getScene().getWindow();
        stage.close();
    }
    public void initializeActor() {
        actorConfirmBtn.setOnAction(this::handleActorUpdate);
    }
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
    @FXML
    public void handleFilmUpdate(ActionEvent event) {
        FilmDAO filmDao = new FilmDAO();
        selectedFilmEntity.setTitle(titleField.getText());
        selectedFilmEntity.setDescription(descArea.getText());
        selectedFilmEntity.setReleaseYear(Integer.parseInt(releaseField.getText()));
        selectedFilmEntity.setRentalDuration(Integer.parseInt(rentalDurField.getText()));
        selectedFilmEntity.setRentalRate(Integer.parseInt(rentalRateField.getText()));
        selectedFilmEntity.setLength(Integer.parseInt(lengthField.getText()));
        selectedFilmEntity.setReplacementCost(Integer.parseInt(repCostField.getText()));
//        selectedFilmEntity.setSpecialFeatures(featureBox.getValue());
//        selectedFilmEntity.setRating(ratingBox.getValue());
        selectedFilmEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        filmDao.update(selectedFilmEntity);
        Stage stage = (Stage) Film_ConfirmBtn.getScene().getWindow();
        stage.close();
    }
    public void initializeFilm() {
        Film_ConfirmBtn.setOnAction(this::handleFilmUpdate);
    }
    @FXML
    public void handleStaffUpdate(ActionEvent event) {
        StaffDAO staffDao = new StaffDAO();
        selectedStaffEntity.setFirstName(Staff_Firstname.getText());
        selectedStaffEntity.setLastName(Staff_Lastname.getText());
        selectedStaffEntity.setEmail(Staff_Email.getText());
        selectedStaffEntity.setActive(Staff_IsActive.isSelected());
        selectedStaffEntity.setUsername(Staff_Username.getText());
        selectedStaffEntity.setPassword(Staff_Password.getText());
        selectedStaffEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        AddressDAO addressDao = new AddressDAO();
        AddressEntity address = addressDao.read(selectedStaffEntity.getAddressId());
        address.setAddress(Staff_address1Field.getText());
        address.setAddress2(Staff_address2Field.getText());
        address.setPostalCode(Staff_PostalField.getText());
        address.setPhone(Staff_PhoneField.getText());
        address.setDistrict(Staff_DistrictField.getText());
        address.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        CityDAO cityDao = new CityDAO();
        CityEntity city = cityDao.read(address.getCityId());
        city.setCity(Staff_CityNameField.getText());
        countryString = Integer.toString(city.getCountryId());

        address.setCity(city);
        selectedStaffEntity.setAddress(address);

        cityDao.update(city);
        addressDao.update(address);
        staffDao.update(selectedStaffEntity);
        Stage stage = (Stage) Staff_ConfirmBtn.getScene().getWindow();
        stage.close();
    }
    public void initializeStaff() {
        Staff_ConfirmBtn.setOnAction(this::handleStaffUpdate);
    }

    @FXML
    public void handlePaymentUpdate(ActionEvent event) {
        PaymentDAO paymentDao = new PaymentDAO();
        if (amountField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid amount.");
            alert.showAndWait();
            return;
        }
        selectedPayment.setAmount(Integer.parseInt(amountField.getText()));
        selectedPayment.setPaymentDate(payDate_Box.getValue());
        selectedPayment.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        CustomerDAO customerDao = new CustomerDAO();
        CustomerEntity customerEntity = customerDao.read(selectedPayment.getCustomerId());
        customerEntity.setCustomerId(Integer.parseInt(Payment_CustomerID.getText()));
        customerDao.update(customerEntity);

        StaffDAO staffDao = new StaffDAO();
        StaffEntity staffEntity = staffDao.read(selectedPayment.getStaffId());
        staffEntity.setStaffId(Integer.parseInt(Payment_StaffID.getText()));
        staffDao.update(staffEntity);

        RentalDAO rentalDao = new RentalDAO();
        RentalEntity rentalEntity = rentalDao.read(selectedPayment.getRentalId());
        rentalEntity.setRentalId(Integer.parseInt(Payment_RentalID.getText()));
        rentalDao.update(rentalEntity);

        paymentDao.update(selectedPayment);
        Stage stage = (Stage) Payments_ConfirmBtn.getScene().getWindow();
        stage.close();
    }
    public void initializePayment() {
        Payments_ConfirmBtn.setOnAction(this::handlePaymentUpdate);
    }



}
