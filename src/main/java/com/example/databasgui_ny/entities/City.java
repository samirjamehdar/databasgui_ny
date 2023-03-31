//package com.example.databasgui_ny.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "city")
//public class City {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int city_id;
//    @Column(name = "city", length = 50)
//    private String city;
//    @Column(name = "country_id")
//    private int country_id;
//    @Column(name = "last_update")
//    private String last_update;
//
//    public City(){}
//
//    public int getCity_id() {return city_id;}
//
//    public void setCity_id(int city_id) {this.city_id = city_id;}
//
//    public String getCity() {return city;}
//
//    public void setCity(String city) {this.city = city;}
//
//    public int getCountry_id() {return country_id;}
//
//    public void setCountry_id(int country_id) {this.country_id = country_id;}
//
//    public String getLast_update() {return last_update;}
//
//    public void setLast_update(String last_update) {this.last_update = last_update;}
//
//}