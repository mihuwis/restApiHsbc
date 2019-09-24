package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<ID extends Long, T extends BaseEntity> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findByID(ID id){
        return map.get(id);
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
        map.remove(id);
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
