package com.progrespoint.restapihsbc.bootstraper;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.model.Customer;
import com.progrespoint.restapihsbc.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBootstraper implements CommandLineRunner {

    private final CustomerService customerService;

    public ApplicationBootstraper(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = customerService.findAll().count();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        Customer customer01 =
                new Customer(1L, "Sam", new Address(1L, "Krakow", "Dluga", "11-111"));
        customerService.save(customer01);

        Customer customer02 =
                new Customer(2L, "John", new Address(2L, "Krakow", "Smolki", "22-222"));
        customerService.save(customer02);
    }
}
