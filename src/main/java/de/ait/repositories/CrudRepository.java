package de.ait.repositories;


import java.util.List;

public interface CrudRepository<T> {
    void save(T model);

    T findById(String id);

    List<T> findAll();
}

