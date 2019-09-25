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
                new Customer("Sam", new Address(1L, "Krakow", "Dluga", "11-111"));
        customerService.save(customer01);

        Customer customer02 =
                new Customer("John", new Address(2L, "Krakow", "Smolki", "22-222"));
        customerService.save(customer02);

        Customer customer03 =
                new Customer("John", new Address(3L, "Wroclaw", "Dluga", "32-322"));
        customerService.save(customer03);

        Customer customer04 =
                new Customer("Lucy", new Address(2L, "Krakow", "Smolki", "22-222"));
        customerService.save(customer04);
    }
}
