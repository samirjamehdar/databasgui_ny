package com.example.databasgui_ny.EntityMapping;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "staff", schema = "sakila")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id", nullable = false)
    private int staffId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
//    @Basic
//    @Column(name = "address_id", nullable = false)
//    private AddressEntity address;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Cascade handlar om relationen mellan objekten, ALL innebär att operationer på huvudobjektet alltså Employee. Alltså tas childobjektet (computer) om vi tar bort huvudobjektet.
    @JoinColumn(name = "address_id")     // When you use @JoinColumn annotation, you are indicating that the entity containing the foreign key (i.e., the owning entity) is the owner of the relationship and it will be responsible for updating the foreign key value in the database whenever the association changes.
    private AddressEntity address;
    @Basic
    @Column(name = "picture", nullable = true)
    private byte[] picture;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
//    @Basic
//    @Column(name = "store_id", nullable = false)
//    private Object storeId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Cascade handlar om relationen mellan objekten, ALL innebär att operationer på huvudobjektet alltså Employee. Alltså tas childobjektet (computer) om vi tar bort huvudobjektet.
    @JoinColumn(name = "store_id")     // When you use @JoinColumn annotation, you are indicating that the entity containing the foreign key (i.e., the owning entity) is the owner of the relationship and it will be responsible for updating the foreign key value in the database whenever the association changes.
    private StoreEntity store;
    @Basic
    @Column(name = "active", nullable = false)
    private boolean active;
    @Basic
    @Column(name = "username", nullable = false, length = 16)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 40)
    private String password;
    @Basic
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressEntity getAddress() {
        return address;
    }
    public Integer getAddressId() {
        return getAddress().getAddressId();
    }

    public void setAddress(AddressEntity addressId) {
        this.address = addressId;
    }

    public String getPicture() {

        return Arrays.toString(picture);
    }

    public void setPicture(String picture) {

        this.picture = picture.getBytes();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStoreId() {
        return getStore().getStoreId();
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public void setStoreId(StoreEntity storeId) {
        this.store = storeId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return active == that.active && Objects.equals(staffId, that.staffId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Arrays.equals(picture, that.picture) && Objects.equals(email, that.email) && Objects.equals(store, that.store) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(staffId, firstName, lastName, address, email, store, active, username, password, lastUpdate);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
