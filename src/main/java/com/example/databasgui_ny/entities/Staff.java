package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int staff_id;
    @Column(name = "first_name", length = 45)
private String first_name;
    @Column(name = "last_name", length = 45)
private String last_name;
    @Column(name = "address_id", length = 255)
private String address_id;
    @Column(name = "picture", length = 255)
private String picture;
    @Column(name = "email", length = 50)
private String email;
    @Column(name = "store_id", length = 255)
private String store_id;
    @Column(name = "active", length = 255)
private String active;
    @Column(name = "username", length = 16)
private String username;
    @Column(name = "password", length = 40)
private String password;
    @Column(name = "last_update", length = 60)
private Date last_update;

//    @ManyToOne
//    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
//    private Store store;

//    @ManyToOne
//    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
//    private Address address;



        public Staff(){}

        public int getStaff_id() {return staff_id;}

        public void setStaff_id(int staff_id) {this.staff_id = staff_id;}

        public String getFirst_name() {return first_name;}

        public void setFirst_name(String first_name) {this.first_name = first_name;}

        public String getLast_name() {return last_name;}

        public void setLast_name(String last_name) {this.last_name = last_name;}

        public String getAddress_id() {return address_id;}

        public void setAddress_id(String address_id) {this.address_id = address_id;}

        public String getPicture() {return picture;}

        public void setPicture(String picture) {this.picture = picture;}

        public String getEmail() {return email;}

        public void setEmail(String email) {this.email = email;}

        public String getStore_id() {return store_id;}

        public void setStore_id(String store_id) {this.store_id = store_id;}

        public String getActive() {return active;}

        public void setActive(String active) {this.active = active;}

        public String getUsername() {return username;}

        public void setUsername(String username) {this.username = username;}

        public String getPassword() {return password;}

        public void setPassword(String password) {this.password = password;}

        public Date getLast_update() {return last_update;}

        public void setLast_update(Date last_update) {this.last_update = last_update;}




}
