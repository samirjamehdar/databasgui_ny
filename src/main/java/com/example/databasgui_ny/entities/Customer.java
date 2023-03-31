package com.example.databasgui_ny.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Column(name = "first_name", length = 45)
    private String first_name;
    @Column(name = "last_name", length = 45)
    private String last_name;
    @Column(name = "email", length = 50)
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "active")
    private boolean active;
    @Column(name = "create_date")
    private Date create_date;
    @Column(name = "last_update")
    private Date last_update;

    public Customer(){}

    public int getCustomer_id() {return customer_id;}

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public Store getStore() {return store;}

    public void setStore(Store store) {this.store = store;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    public boolean isActive() {return active;}

    public void setActive(boolean active) {this.active = active;}

    public java.sql.Date getCreate_date() {return create_date;}

    public void setCreate_date(java.sql.Date create_date) {this.create_date = create_date;}

    public java.sql.Date getLast_update() {return last_update;}

    public void setLast_update(java.sql.Date last_update) {this.last_update = last_update;}

}