package com.progrespoint.restapihsbc.model;

public class Customer extends BaseEntity {


    private String name;
    private Address address;

    public Customer(Long id, String name, Address address) {
        super(id);
        this.name = name;
        this.address = address;
    }

    public Customer(String name, Address address) {
        super();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
