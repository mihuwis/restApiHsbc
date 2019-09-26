package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.Customer;
import com.progrespoint.restapihsbc.services.AddressService;
import com.progrespoint.restapihsbc.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Profile("map")
public class CustomerMapService extends AbstractMapService<Long, Customer> implements CustomerService {

    private final AddressService addressService;

    public CustomerMapService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public Optional<Customer> findByNameAndId(Long id, String name) {
        return super.map.values()
                .stream()
                .filter(customer -> customer.getName().equals(name) && customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public Stream<Customer> findAllUsersWithName(String name) {
        return super.map.values()
                .stream()
                .filter(customer -> customer.getName()
                        .equals(name));
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Stream<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Customer customer) {
        super.delete(customer);
    }

    @Override
    public Customer save(Customer customer) {
        if(customer != null){
            if(customer.getAddress() != null){
                return super.save(customer);
            } else {
                throw new RuntimeException("Address is required");
            }
        }
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return super.findByID(id);
    }

}
