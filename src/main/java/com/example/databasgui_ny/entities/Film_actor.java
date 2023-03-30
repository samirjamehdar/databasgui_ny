package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_actor")
public class Film_actor {
    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "last_update", length = 60)
    private String last_update;

    public Film_actor(){}

    public Film_actor(Actor actor, Film film){
        this.actor = actor;
        this.film = film;
    }

    public Actor getActor() {return actor;}

    public void setActor(Actor actor) {this.actor = actor;}

    public Film getFilm() {return film;}

    public void setFilm(Film film) {this.film = film;}

    public String getLast_update() {return last_update;}

    public void setLast_update(String last_update) {this.last_update = last_update;}

}
