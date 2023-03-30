package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "address2", length = 50)
    private String address2;
    @Column(name = "district", length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postal_code;
    @Column(name = "phone", length = 20)
    private String phone;
    @Column(name = "last_update")
    private String last_update;

    public Address(){}

    public int getAddress_id() {return address_id;}

    public void setAddress_id(int address_id) {this.address_id = address_id;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getAddress2() {return address2;}

    public void setAddress2(String address2) {this.address2 = address2;}

    public String getDistrict() {return district;}

    public void setDistrict(String district) {this.district = district;}

    public City getCity() {return city;}

    public void setCity_id(City city) {this.city = city;}

    public String getPostal_code() {return postal_code;}

    public void setPostal_code(String postal_code) {this.postal_code = postal_code;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getLast_update() {return last_update;}

    public void setLast_update(String last_update) {this.last_update = last_update;}

}

