package com.example.databasgui_ny.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;
    @Column(name = "manager_staff_id", length = 255)
    private String manager_staff_id;
    @Column(name = "address_id", length = 255)
    private String address_id;
    @Column(name = "last_update", length = 60)
    private String last_update;

    public Store(){}

    public int getStore_id() {return store_id;}

    public void setStore_id(int store_id) {this.store_id = store_id;}

    public String getManager_staff_id() {return manager_staff_id;}

    public void setManager_staff_id(String manager_staff_id) {this.manager_staff_id = manager_staff_id;}

    public String getAddress_id() {return address_id;}

    public void setAddress_id(String address_id) {this.address_id = address_id;}

    public String getLast_update() {return last_update;}

    public void setLast_update(String last_update) {this.last_update = last_update;}
}
