package org.example.test;

import org.example.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private static CustomerService customerService;

    @Before
    public void init(){
        customerService = new CustomerService();
    }

    @Test
    public void test(){
        customerService.register("李四", "1234567");
    }
}
