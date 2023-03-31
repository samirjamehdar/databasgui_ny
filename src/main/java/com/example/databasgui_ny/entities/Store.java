package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int store_id;
    /*@Column(name = "manager_staff_id", length = 255)
    private String manager_staff_id;
    @Column(name = "address_id", length = 255)
    private String address_id;*/
    @Column(name = "last_update", length = 60)
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    private Staff managerStaff;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<Inventory> inventoryList;



    public Store( Staff managerStaff, String address_id, String last_update) {
        this.managerStaff = managerStaff;
        this.address = address;
        this.last_update = last_update;
    }

    public Store(){}

    public int getStore_id() {return store_id;}

    public void setStore_id(int store_id) {this.store_id = store_id;}

    public Staff getManager_staff_id() {return managerStaff;}

    public void setManager_staff_id(Staff manager_staff_id) {this.managerStaff = manager_staff_id;}

    public Address address() {return address;}

    public void setAddress_id(String address_id) {this.address = address;}

    public Date getLast_update() {return last_update;}

    public void setLast_update(Date last_update) {this.last_update = last_update;}
}
