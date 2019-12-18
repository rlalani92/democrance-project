package com.democrance.service.customer;

import com.democrance.dataaccessobject.CustomerRepository;
import com.democrance.domainobject.CustomerDo;
import com.democrance.exception.EntityNotFoundException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDo> findAll() {
        return Lists.newArrayList(customerRepository.findAll());
    }

    @Override
    public CustomerDo  find(Long id) throws EntityNotFoundException {

        CustomerDo customerDo = customerRepository.findOne(id);

        if (customerDo == null) {
            throw new EntityNotFoundException("Could not find entity with id: " + id);
        }

        return customerDo;
    }

    @Override
    public CustomerDo create(CustomerDo customerDo) {
        return customerRepository.save(customerDo);
    }
}
