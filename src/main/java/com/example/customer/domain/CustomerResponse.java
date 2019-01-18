package com.example.customer.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object of the result of a customer placement.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CustomerResponse {

    private String name;

    public static CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(customer.getName());
    }

}
