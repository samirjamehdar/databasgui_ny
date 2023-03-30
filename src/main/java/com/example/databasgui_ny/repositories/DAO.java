package com.example.databasgui_ny.repositories;

import java.util.List;

public interface DAO<T> {
    void create(T t);
    List<T> readAll();
    T read(int id);
    boolean update(T t);
    void delete(int id);
}
