package com.progrespoint.restapihsbc.services.map;

import com.progrespoint.restapihsbc.model.Address;
import com.progrespoint.restapihsbc.services.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class AddressMapService extends AbstractMapService<Long, Address> implements AddressService {
    @Override
    public Set<Address> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Address object) {
        super.delete(object);
    }

    @Override
    public Address save(Address object) {
        return super.save(object);
    }

    @Override
    public Address findById(Long id) {
        return super.findByID(id);
    }
}
