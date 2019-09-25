package com.progrespoint.restapihsbc.cotrollers;

import com.progrespoint.restapihsbc.model.Customer;
import com.progrespoint.restapihsbc.services.CustomerService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final String REL_SELF = "self";
    private final String REL_CUSTOMER_BY_ID = "customersById";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Resources<Resource<Customer>>> getAllCustomers(){
        Resources<Resource<Customer>> resources = new Resources<>(
                customerService.findAll().map(this::resource)
                .collect(Collectors.toList()));
        resources.add(linkTo(methodOn(CustomerController.class)
        .getCustomerById(null)).withRel(REL_CUSTOMER_BY_ID));
        addFindAllCustomersLink(resources, REL_SELF);
        return ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource<Customer>> getCustomerById(@PathVariable Long id){
        return customerService.findById(id)
                .map(this::resource)
                .map(this::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private Resource<Customer> resource(Customer customer){
        Resource<Customer> customerResource = new Resource<>(customer);
        customerResource
                .add(linkTo(methodOn(CustomerController.class)
                .getCustomerById(customer.getId()))
                .withSelfRel());
        return customerResource;
    }

    private <T> ResponseEntity<T> ok(T body){
        return ResponseEntity.ok().body(body);
    }

    private void addFindAllCustomersLink(Resources<Resource<Customer>> resources, String rel){
        resources
                .add(linkTo(methodOn(CustomerController.class).getAllCustomers())
                .withRel(rel));
    }

    private void addFindCustomerByIdLink(Resources<Resource<Customer>> resources, String rel){

    }



}
