package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_text")
public class Film_text {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "description", length = 255)
    private String description;

public Film_text(){}

    public Film_text(Film film, String title, String description){
        this.film = film;
        this.title = title;
        this.description = description;
    }

        public Film getFilm() {return film;}

        public void setFilm(Film film_id) {this.film = film;}

        public String getTitle() {return title;}

        public void setTitle(String title) {this.title = title;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}

    @Override
    public String toString() {
        return "Film_text{" +
                "film=" + film +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
