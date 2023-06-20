package de.ait.repositories;

public interface CrudRepository<T> {
    void save(T model);

    T findById(String id);
}

