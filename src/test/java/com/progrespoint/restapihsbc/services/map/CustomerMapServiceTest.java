package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.acl.Owner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapServiceTest {

    private CustomerMapService customerMapService;

    private final Long CUSTOMER_ID = 1L;

    @BeforeEach
    void setUp() {
        customerMapService = new CustomerMapService(new AddressMapService());
        customerMapService.save(new Customer(1L, "Sam", new Address(CUSTOMER_ID, "B", "A", "111")));
    }

    @Test
    void findByNameAndId() {
    }

    @Test
    void findAllUsersWithName() {
        // When
        Customer customer = customerMapService.findAllUsersWithName("Sam").findAny().orElse(null);

        // Then
        assertEquals("Sam", customer.getName());
    }

    @Test
    void findAll() {
        // When
        Stream<Customer> customerStream = customerMapService.findAll();

        // Then
        assertEquals(CUSTOMER_ID, (Long) customerStream.count());
    }

    @Test
    void delete() {
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Customer customer2 = new Customer(id, "Ed", new Address(1L, "A", "B", "1111"));

        Customer savedCustomer = customerMapService.save(customer2);

        assertEquals(id, savedCustomer.getId());
    }

    @Test
    void saveNoId(){
        Long id = 2L;
        Customer customer2 = new Customer("Ed", new Address(1L, "A", "B", "1111"));

        Customer savedCustomer = customerMapService.save(customer2);

        assertEquals(id, savedCustomer.getId());
    }

    @Test
    void findById() {
        // When
        Customer customer = customerMapService.findById(CUSTOMER_ID).orElse(null);

        // Then
        assertEquals(CUSTOMER_ID, customer.getId());
    }
}