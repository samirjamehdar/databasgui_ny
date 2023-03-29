package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_text")
public class Film_text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "description", length = 255)
    private String description;

public Film_text(){}

        public int getFilm_id() {return film_id;}

        public void setFilm_id(int film_id) {this.film_id = film_id;}

        public String getTitle() {return title;}

        public void setTitle(String title) {this.title = title;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}
}
