package com.example.databasgui_ny.entities;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Objects;

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof FilmActor)) return false;
//        FilmActor filmActor = (FilmActor) o;
//        return actor == filmActor.actor &&
//                film == filmActor.film;
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(actor, film);
//    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actor_id=" + actor +
                ", film_id='" + film + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }

}
