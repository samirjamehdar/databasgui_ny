package com.example.databasgui_ny.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    private String first_name;
//    @Column(name = "last_name", length = 45)
    private String last_name;
//    @Column(name = "last_update")
//    private String last_update;


    public Actor(){}

    public int getActor_id() {return actor_id;}

    public void setActor_id(int actor_id) {this.actor_id = actor_id;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

//    public String getLast_update() {return last_update;}
//
//    public void setLast_update(String last_update) {this.last_update = last_update;}


    @Override
    public String toString() {
        return "Actor{" +
                "actor_id=" + actor_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}

