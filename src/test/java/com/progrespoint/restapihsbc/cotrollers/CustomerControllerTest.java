package com.progrespoint.restapihsbc.cotrollers;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.model.Customer;
import com.progrespoint.restapihsbc.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.stream.Stream;
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
    void getAllCustomers_StreamOfCustomersGiven_ShouldReturnStatus200() throws Exception {
        // When
        when(customerService.findAll()).thenReturn(customerStream);

        // Then
        mockMvc.perform(get("/api/v1/customers"))
                .andExpect(status().is(200));
    }

    @Test
    void getCustomerById() {
        // When
        // Then
    }

    @Test
    void getCustomersByName() {
        // When
        // Then
    }

    @Test
    void addCustomer() {
        // When
        // Then
    }

}