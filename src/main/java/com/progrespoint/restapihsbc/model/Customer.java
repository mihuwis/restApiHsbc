package com.progrespoint.restapihsbc.model;

import java.util.Objects;

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

    public Customer(){}

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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
