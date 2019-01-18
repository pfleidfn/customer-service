package com.example.customer.contract;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.customer.domain.Customer;
import org.junit.Before;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.customer.service.CustomerService;

import java.util.Optional;

public class CustomerBase extends MockMvcBase {

    @MockBean
    private CustomerService customerService;

    @Before
    public void configureCustomerServiceMock() {
        when(customerService.getCustomer(anyLong())).thenReturn(Optional.empty());
        when(customerService.getCustomer(1))
                .thenReturn(Optional.of(new Customer("Florian", "Pfleiderer")));
    }

}
