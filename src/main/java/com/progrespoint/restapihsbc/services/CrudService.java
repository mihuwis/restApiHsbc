package com.progrespoint.restapihsbc.services;

import java.util.Set;

public interface CrudService<ID, T> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);
}
