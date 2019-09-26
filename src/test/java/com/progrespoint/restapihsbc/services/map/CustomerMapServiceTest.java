package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapServiceTest {

    private CustomerMapService customerMapService;

    private final Long CUSTOMER_ONE_ID = 1L;
    private final Long CUSTOMER_TWO_ID = 2L;

    @BeforeEach
    void setUp() {
        customerMapService = new CustomerMapService(new AddressMapService());
        customerMapService.save(
                new Customer(CUSTOMER_ONE_ID, "Sam", new Address(1L, "B", "A", "111")));
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
        assertEquals(CUSTOMER_ONE_ID, (Long) customerStream.count());
    }

    @Test
    void delete() {
    }

    @Test
    void saveExistingId() {
        // Given
        Customer customer2 = new Customer(CUSTOMER_TWO_ID, "Ed", new Address(1L, "A", "B", "1111"));

        // When
        Customer savedCustomer = customerMapService.save(customer2);

        // Then
        assertEquals(CUSTOMER_TWO_ID, savedCustomer.getId());
    }

    @Test
    void saveNoId(){
        // Given
        Customer customer2 = new Customer("Ed", new Address(1L, "A", "B", "1111"));

        // When
        Customer savedCustomer = customerMapService.save(customer2);

        // Then
        assertEquals(CUSTOMER_TWO_ID, savedCustomer.getId());
    }

    @Test
    void findById() {
        // When
        Customer customer = customerMapService.findById(CUSTOMER_ONE_ID).orElse(null);

        // Then
        assertEquals(CUSTOMER_ONE_ID, customer.getId());
    }
}