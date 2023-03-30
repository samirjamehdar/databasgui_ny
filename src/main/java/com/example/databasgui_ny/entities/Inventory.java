package com.example.databasgui_ny.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventory_id;
    @Column(name = "film_id", length = 255)
private String film_id;
    @Column(name = "store_id", length = 255)
private String store_id;
    @Column(name = "last_update", length = 60)
private String last_update;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;



        public Inventory(){}

        public int getInventory_id() {return inventory_id;}

        public void setInventory_id(int inventory_id) {this.inventory_id = inventory_id;}

        public String getFilm_id() {return film_id;}

        public void setFilm_id(String film_id) {this.film_id = film_id;}

        public String getStore_id() {return store_id;}

        public void setStore_id(String store_id) {this.store_id = store_id;}

        public String getLast_update() {return last_update;}

        public void setLast_update(String last_update) {this.last_update = last_update;}

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", film_id='" + film_id + '\'' +
                ", store_id='" + store_id + '\'' +
                ", last_update='" + last_update + '\'' +
                ", film=" + film +
                ", store=" + store +
                '}';
    }
}
