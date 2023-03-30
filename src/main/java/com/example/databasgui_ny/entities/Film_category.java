package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_category")
public class Film_category {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "last_update")
    private String last_update;

    public Film_category() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }



}
