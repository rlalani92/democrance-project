package com.democrance.service.customer;

import com.democrance.domainobject.CustomerDo;
import com.democrance.exception.EntityNotFoundException;

import java.util.List;

public interface CustomerService {
    List<CustomerDo> findAll();
    CustomerDo find(Long id) throws EntityNotFoundException;
    CustomerDo create(CustomerDo customerDo);
}
