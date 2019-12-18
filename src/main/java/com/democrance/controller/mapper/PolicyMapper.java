package com.democrance.controller.mapper;

import com.democrance.datatransferobject.PolicyDto;
import com.democrance.domainobject.CustomerDo;
import com.democrance.domainobject.PolicyDo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyMapper
{
    public static PolicyDo makePolicyDo(PolicyDto policyDto) {
        Date date = new Date();
        PolicyDo policyDo = new PolicyDo();
        policyDo.setCover(policyDto.getCover());
        policyDo.setPolicyType(policyDto.getPolicyType());
        policyDo.setPremium(policyDto.getPremium());
        CustomerDo customerDo = new CustomerDo();
        customerDo.setId(policyDto.getCustomerDto().getId());
        policyDo.setCustomer(customerDo);
        policyDo.setCreateDateTime(new Timestamp(date.getTime()));
        policyDo.setUpdateDateTime(new Timestamp(date.getTime()));
        return policyDo;
    }


    public static PolicyDto makePolicyDto(PolicyDo policyDo) {
        PolicyDto policyDto = new PolicyDto();
        policyDto.setId(policyDo.getId());
        policyDto.setCover(policyDo.getCover());
        policyDto.setPolicyType(policyDo.getPolicyType());
        policyDto.setPremium(policyDo.getPremium());
        policyDto.setCustomerDto(CustomerMapper.makeCustomerDto(policyDo.getCustomer()));
        return policyDto;
    }


    public static List<PolicyDto> makePolicyDtoList(Collection<PolicyDo> policies)
    {
        return policies.stream()
                .map(PolicyMapper::makePolicyDto)
                .collect(Collectors.toList());
    }
}
