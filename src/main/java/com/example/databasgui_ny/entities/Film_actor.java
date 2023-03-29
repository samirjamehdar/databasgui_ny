package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Film_actor")
public class Film_actor {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    @Column(name = "film_id", length = 255)
    private String film_id;
    @Column(name = "last_update", length = 60)
    private String last_update;

    public Film_actor(){}

    public int getActor_id() {return actor_id;}

    public void setActor_id(int actor_id) {this.actor_id = actor_id;}

    public String getFilm_id() {return film_id;}

    public void setFilm_id(String film_id) {this.film_id = film_id;}

    public String getLast_update() {return last_update;}

    public void setLast_update(String last_update) {this.last_update = last_update;}

}
