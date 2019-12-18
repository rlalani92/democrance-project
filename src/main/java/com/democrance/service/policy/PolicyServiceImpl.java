package com.democrance.service.policy;

import com.democrance.dataaccessobject.CustomerRepository;
import com.democrance.dataaccessobject.PolicyRepository;
import com.democrance.domainobject.CustomerDo;
import com.democrance.domainobject.PolicyDo;
import com.democrance.exception.ConstraintsViolationException;
import com.democrance.exception.EntityNotFoundException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<PolicyDo> findAll() {
        return Lists.newArrayList(policyRepository.findAll());
    }

    @Override
    public PolicyDo find(Long id) throws EntityNotFoundException {
        PolicyDo policyDo =  policyRepository.findOne(id);

        if (policyDo == null){
            throw new EntityNotFoundException("Could not find entity with id: " + id);
        }

        return policyDo;
    }

    @Override
    public PolicyDo create(PolicyDo policyDo) throws ConstraintsViolationException {

        if (policyDo.getCustomer() == null || policyDo.getCustomer().getId() == null){
            throw new ConstraintsViolationException("Customer id cannot be null");
        }

        CustomerDo customerDo = customerRepository.findOne(policyDo.getCustomer().getId());
        if (customerDo == null){
            throw new ConstraintsViolationException("Could not find customer entity with id: " + policyDo.getCustomer().getId());
        }
        policyDo.setCustomer(customerDo);
        return policyRepository.save(policyDo);
    }
}
