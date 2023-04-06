package com.example.databasgui_ny.EntityMapping;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_category", schema = "sakila")
@IdClass(FilmCategoryEntityPK.class)
public class FilmCategoryEntity implements Serializable {

    @Id
    @Column(name = "film_id", nullable = false)
    private int filmId;

    @Id
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public FilmCategoryEntity(int filmId, int categoryId, Timestamp lastUpdate) {
        this.filmId = filmId;
        this.categoryId = categoryId;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryEntity() {

    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntity that = (FilmCategoryEntity) o;
        return Objects.equals(filmId, that.filmId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId, lastUpdate);
    }
}
