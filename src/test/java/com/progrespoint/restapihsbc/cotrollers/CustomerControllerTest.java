package com.progrespoint.restapihsbc.cotrollers;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.model.Customer;
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

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Optional<Customer> optionalCustomer;
    private Stream<Customer> customerStream;

//    private static String BASE_PATH = "http://localhost/customers";

    @BeforeEach
    void setUp() {
        Customer customer1 = new Customer(1L, "Sam", new Address(1L, "A", "B", "C"));
        Customer customer2 = new Customer(2L, "Eve", new Address(2L, "D", "E", "F"));
        optionalCustomer = Optional.of(customer1);
        customerStream = Stream.of(customer1, customer2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(customerController)
                .build();
    }

    @Test
    void getAllCustomers() throws Exception {
        when(customerService.findAll()).thenReturn(customerStream);

        mockMvc.perform(get("/customers"))
                .andExpect(status().is(200));
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