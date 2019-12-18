package com.democrance.service;

import com.democrance.Application;
import com.democrance.dataaccessobject.CustomerRepository;
import com.democrance.domainobject.CustomerDo;
import com.democrance.exception.EntityNotFoundException;
import com.democrance.service.customer.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test(expected = EntityNotFoundException.class)
    public void testInvalidCustomer() throws EntityNotFoundException {
        customerService.find(2l);
    }

    @Test
    public void testValidCustomer() throws EntityNotFoundException {
        assert customerService.find(1l) != null;
    }

    @Test
    public void testFindAllCustomers(){
        assert customerService.findAll().size() > 0 ;
    }

    @Test
    public void createCustomer() {
        CustomerDo customerDo = new CustomerDo();
        customerDo.setFirstName("Rehman");
        customerDo.setLastName("Lalani");
        assert customerService.create(customerDo).getId() > 0;
    }

}
