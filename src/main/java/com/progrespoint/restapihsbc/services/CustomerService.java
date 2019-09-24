package com.progrespoint.restapihsbc.services;

import com.progrespoint.restapihsbc.model.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerService extends CrudService<Long, Customer> {

    Optional<Customer> findByNameAndId(Long id, String name);

    Set<Customer> findAllUsersWithName(String name);
}
