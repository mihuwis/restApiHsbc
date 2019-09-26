package com.progrespoint.restapihsbc.cotrollers;

import com.progrespoint.restapihsbc.services.map.AddressMapService;
import com.progrespoint.restapihsbc.services.map.CustomerMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    private MockMvc mockMvc;
    private CustomerController customerController;

    private static String BASE_PATH = "http://localhost/customers";

    @BeforeEach
    void setUp() {
        customerController = new CustomerController(new CustomerMapService(new AddressMapService()));
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getCustomersByName() {
    }

    @Test
    void addCustomer() {
    }
}