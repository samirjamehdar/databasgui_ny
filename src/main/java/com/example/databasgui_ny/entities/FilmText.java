package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_text")
public class FilmText {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    //    @Column(name = "film_id", length = 255)
//    private int film_id;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "description", length = 255)
    private String description;

    public FilmText(){}

    public Film getFilm() {return film;}

    public void setFilm(Film film) {this.film = film;}
//    public int getFilm() {return film_id;}
//
//    public void setFilm(int film_id) {this.film_id = film_id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    @Override
    public String toString() {
        return "FilmText{" +
                "film_id=" + film +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
