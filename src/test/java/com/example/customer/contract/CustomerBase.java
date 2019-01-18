package com.example.customer.contract;

import com.example.customer.domain.Customer;
import com.example.customer.service.CustomerService;
import org.junit.Before;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerBase extends MockMvcBase {

    @MockBean
    private CustomerService customerService;

    @Before
    public void configureCustomerServiceMock() {
        when(customerService.getCustomer(anyLong())).thenReturn(Optional.empty());
        when(customerService.getCustomer(1))
                .thenReturn(Optional.of(new Customer("Florian Pfleiderer")));
    }

}
