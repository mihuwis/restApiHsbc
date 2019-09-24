package com.progrespoint.restapihsbc.services;

import com.progrespoint.restapihsbc.model.Customer;

import java.util.Set;

public interface CustomerService extends CrudService<Long, Customer> {

    Customer findByNameAndId(Long id, String name);

    Set<Customer> findAllUsersWithName(String name);
}
