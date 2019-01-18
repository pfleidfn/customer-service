package com.example.customer.service;

import com.example.customer.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    private final Map<Long, Customer> customers = new HashMap<>();

    @PostConstruct
    public void insertDemoCustomers() {
        customers.put(1L, new Customer("Florian Pfleiderer"));
        customers.put(2L, new Customer("Frank Scheffler"));
    }

    public Optional<Customer> getCustomer(long customerId) {
        return Optional.ofNullable(customers.get(customerId));
    }

}
