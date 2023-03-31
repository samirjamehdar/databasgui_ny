//package com.example.databasgui_ny.entities;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "Film")
//public class Film {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int film_id;
//    @Column(name = "title", length = 255)
//    private String title;
//    @Column(name = "description", length = 255)
//    private String description;
//    @Column(name = "release_year", length = 255)
//    private String release_year;
//    @Column(name = "language_id", length = 255)
//    private String language_id;
//    @Column(name = "original_language_id", length = 255)
//    private String original_language_id;
//    @Column(name = "rental_duration", length = 255)
//    private String rental_duration;
//    @Column(name = "rental_rate", length = 255)
//    private String rental_rate;
//    @Column(name = "length", length = 255)
//    private String length;
//    @Column(name = "replacement_cost", length = 255)
//    private String replacement_cost;
//    @Column(name = "rating", length = 255)
//    private String rating;
//    @Column(name = "special_features", length = 255)
//    private String special_features;
//    @Column(name = "last_update", length = 60)
//    private String last_update;
//
//    @OneToMany(mappedBy = "film")
//    private List<Inventory> inventoryList;
//
//    public Film(){}
//
//    public int getFilm_id() {return film_id;}
//
//    public void setFilm_id(int film_id) {this.film_id = film_id;}
//
//    public String getTitle() {return title;}
//
//    public void setTitle(String title) {this.title = title;}
//
//    public String getDescription() {return description;}
//
//    public void setDescription(String description) {this.description = description;}
//
//    public String getRelease_year() {return release_year;}
//
//    public void setRelease_year(String release_year) {this.release_year = release_year;}
//
//    public String getLanguage_id() {return language_id;}
//
//    public void setLanguage_id(String language_id) {this.language_id = language_id;}
//
//    public String getOriginal_language_id() {return original_language_id;}
//
//    public void setOriginal_language_id(String original_language_id) {this.original_language_id = original_language_id;}
//
//    public String getRental_duration() {return rental_duration;}
//
//    public void setRental_duration(String rental_duration) {this.rental_duration = rental_duration;}
//
//    public String getRental_rate() {return rental_rate;}
//
//    public void setRental_rate(String rental_rate) {this.rental_rate = rental_rate;}
//
//    public String getLength() {return length;}
//
//    public void setLength(String length) {this.length = length;}
//
//    public String getReplacement_cost() {return replacement_cost;}
//
//    public void setReplacement_cost(String replacement_cost) {this.replacement_cost = replacement_cost;}
//
//    public String getRating() {return rating;}
//
//    public void setRating(String rating) {this.rating = rating;}
//
//    public String getSpecial_features() {return special_features;}
//
//    public void setSpecial_features(String special_features) {this.special_features = special_features;}
//
//    public String getLast_update() {return last_update;}
//}
