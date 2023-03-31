package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Film_actor")
public class FilmActor {
    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "last_update", length = 60)
    private Date last_update;

    public FilmActor(){}

    public Actor getActor() {return actor;}

    public void setActor(Actor actor) {this.actor = actor;}

    public Film getFilm() {return film;}

    public void setFilm(Film film) {this.film = film;}

    public java.sql.Date getLast_update() {return last_update;}

    public void setLast_update(java.sql.Date last_update) {this.last_update = last_update;}

}
