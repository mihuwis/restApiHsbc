package com.progrespoint.restapihsbc.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface CrudService<ID, T> {

    Stream<T> findAll();

    Optional<T> findById(ID id);

    T save(T object);

    void delete(T object);
}
