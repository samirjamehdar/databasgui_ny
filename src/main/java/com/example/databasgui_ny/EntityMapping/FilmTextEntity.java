package com.example.databasgui_ny.EntityMapping;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "film_text", schema = "sakila")
public class FilmTextEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id", nullable = false)
    private int filmId;
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextEntity that = (FilmTextEntity) o;
        return filmId == that.filmId && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description);
    }

    @Override
    public String toString() {
        return "FilmTextEntity{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
