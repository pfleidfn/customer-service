package com.example.customer.rest;

import com.example.customer.domain.Customer;
import com.example.customer.domain.CustomerResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer/{customerId}")
    public CustomerResponse customerCustomer(@PathVariable long customerId) {
        Customer customer = customerService.getCustomer(customerId).orElseThrow(IllegalArgumentException::new);
        return CustomerResponse.fromCustomer(customer);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException(IllegalArgumentException e) {

    }


}
