package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.repositories.DAO;

import java.util.List;

public class ActorDAO implements DAO<Actor> {

    @Override
    public void create(Actor actor) {
    }
    @Override
    public List<Actor> readAll() {
        return null;
    }

    @Override
    public Actor read(int id) {
        return null;
    }

    @Override
    public boolean update(Actor actor) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
