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
    private  final Long EMPTY = 0L;

    @BeforeEach
    void setUp() {
        customerMapService = new CustomerMapService(new AddressMapService());
        customerMapService.save(
                new Customer(CUSTOMER_ONE_ID, "Sam", new Address(1L, "B", "A", "111")));
    }

    @Test
    void findAllUsersWithName_CustomerGiven_ShouldMatchNameOfCustomer() {
        // When
        Customer customer = customerMapService.findAllUsersWithName("Sam").findAny().orElse(null);

        // Then
        assertEquals("Sam", customer.getName());
    }

    @Test
    void findAll_ListOfCustomerGiven_ShouldReturnCorrectLengthOfList() {
        // When
        Stream<Customer> customerStream = customerMapService.findAll();

        // Then
        assertEquals(CUSTOMER_ONE_ID, (Long) customerStream.count());
    }

    @Test
    void deleteById_OnlyUserRemovedFromList_ShouldResultInEmptyList() {
        // When
        customerMapService.deleteById(CUSTOMER_ONE_ID);
        Stream<Customer> customerStream = customerMapService.findAll();

        // Then
        assertEquals(EMPTY, (Long) customerStream.count());
    }

    @Test
    void save_CustomerWithIdGiven_ShouldReturnThisSameId() {
        // Given
        Customer customer2 = new Customer(CUSTOMER_TWO_ID, "Ed", new Address(1L, "A", "B", "1111"));

        // When
        Customer savedCustomer = customerMapService.save(customer2);

        // Then
        assertEquals(CUSTOMER_TWO_ID, savedCustomer.getId());
    }

    @Test
    void save_CustomerWithNoIdGiven_ShouldReturnCustomerWithGeneratedId(){
        // Given
        Customer customer2 = new Customer("Ed", new Address(1L, "A", "B", "1111"));

        // When
        Customer savedCustomer = customerMapService.save(customer2);

        // Then
        assertEquals(CUSTOMER_TWO_ID, savedCustomer.getId());
    }

    @Test
    void findById_ListOfCustomersGiven_ShouldFindRequestedCustomer() {
        // When
        Customer customer = customerMapService.findById(CUSTOMER_ONE_ID).orElse(null);

        // Then
        assertEquals(CUSTOMER_ONE_ID, customer.getId());
    }
}