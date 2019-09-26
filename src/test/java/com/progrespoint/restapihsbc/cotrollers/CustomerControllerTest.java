package com.progrespoint.restapihsbc.cotrollers;

import com.progrespoint.restapihsbc.services.CustomerService;
import com.progrespoint.restapihsbc.services.map.AddressMapService;
import com.progrespoint.restapihsbc.services.map.CustomerMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

//    private static String BASE_PATH = "http://localhost/customers";

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllCustomers() throws Exception {

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