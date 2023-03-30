package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rental_id;
    @Column(name = "rental_date", length = 60)
    private String rental_date;
    @Column(name = "inventory_id", length = 255)
    private String inventory_id;
    @Column(name = "customer_id", length = 255)
    private String customer_id;
    @Column(name = "return_date", length = 60)
    private String return_date;
    @Column(name = "staff_id", length = 255)
    private String staff_id;
    @Column(name = "last_update", length = 60)
    private String last_update;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staff;


    public Rental(){}

    public int getRental_id() {return rental_id;}

    public void setRental_id(int rental_id) {this.rental_id = rental_id;}

    public String getRental_date() {return rental_date;}

    public void setRental_date(String rental_date) {this.rental_date = rental_date;}

    public String getInventory_id() {return inventory_id;}

    public void setInventory_id(String inventory_id) {this.inventory_id = inventory_id;}

    public String getCustomer_id() {return customer_id;}

    public void setCustomer_id(String customer_id) {this.customer_id = customer_id;}

    public String getReturn_date() {return return_date;}

    public void setReturn_date(String return_date) {this.return_date = return_date;}

    public String getStaff_id() {return staff_id;}

    public void setStaff_id(String staff_id) {this.staff_id = staff_id;}

    public String getLast_update() {return last_update;}

    public void setLast_update(String last_update) {this.last_update = last_update;}




}
