package com.democrance.controller;

import com.democrance.controller.mapper.CustomerMapper;
import com.democrance.datatransferobject.CustomerDto;
import com.democrance.exception.EntityNotFoundException;
import com.democrance.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(CustomerMapper.makeCarDTOList(customerService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer( @PathVariable(name = "customerId") Long customerId) throws EntityNotFoundException {
        return new ResponseEntity<>(CustomerMapper.makeCustomerDto(customerService.find(customerId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCar( @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(CustomerMapper.makeCustomerDto(
                customerService.create(
                        CustomerMapper.makeCustomerDo(customerDto))), HttpStatus.CREATED);
    }
}
