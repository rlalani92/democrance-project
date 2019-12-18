package com.democrance.controller.mapper;

import com.democrance.datatransferobject.CustomerDto;
import com.democrance.domainobject.CustomerDo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper
{
    public static CustomerDo makeCustomerDo(CustomerDto customerDto) {
        Date date = new Date();
        CustomerDo customerDo = new CustomerDo();
        customerDo.setDob(customerDto.getDob());
        customerDo.setFirstName(customerDto.getFirstName());
        customerDo.setLastName(customerDto.getLastName());
        customerDo.setCreateDateTime(new Timestamp(date.getTime()));
        customerDo.setUpdateDateTime(new Timestamp(date.getTime()));
        return customerDo;
    }


    public static CustomerDto makeCustomerDto(CustomerDo customerDo) {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setDob(customerDo.getDob());
        customerDto.setFirstName(customerDo.getFirstName());
        customerDto.setLastName(customerDo.getLastName());
        customerDto.setId(customerDo.getId());
        return customerDto;

    }


    public static List<CustomerDto> makeCarDTOList(Collection<CustomerDo> customers)
    {
        return customers.stream()
                .map(CustomerMapper::makeCustomerDto)
                .collect(Collectors.toList());
    }
}
