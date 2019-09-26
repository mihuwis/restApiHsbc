package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.BaseEntity;

import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractMapService<ID extends Long, T extends BaseEntity> {

    Map<Long, T> map = new HashMap<>();

    Stream<T> findAll(){
        return map.values().stream();
    }

    Optional<T> findByID(ID id){
        return map.values().stream()
        .filter(value-> value.getId().equals(id))
                .findFirst();
    }

    T save(T object){
        if(object != null){
            setIdInObject(object);
            map.put(object.getId(), object);
        } else {
            throw new NoSuchElementException("Object cannot be null");
        }
        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.entrySet().removeIf(entry -> entry.getValue().getId().equals(id));
    }

    private void setIdInObject(T object){
        if(object.getId() == null){
            object.setId(getNextIdNumber());
        }
    }

    private Long getNextIdNumber(){
        long id;
        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            id = 1L;
        }
        return id;
    }
}
