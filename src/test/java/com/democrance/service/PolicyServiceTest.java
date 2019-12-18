package com.democrance.service;

import com.democrance.Application;
import com.democrance.dataaccessobject.CustomerRepository;
import com.democrance.domainobject.CustomerDo;
import com.democrance.domainobject.PolicyDo;
import com.democrance.exception.ConstraintsViolationException;
import com.democrance.exception.EntityNotFoundException;
import com.democrance.service.policy.PolicyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test(expected = EntityNotFoundException.class)
    public void testInvalidPolicy() throws EntityNotFoundException {
         policyService.find(2l);
    }

    @Test
    public void testValidPolicy() throws EntityNotFoundException {
        assert policyService.find(1l) != null;
    }

    @Test
    public void testFindAllPolicies(){
        assert policyService.findAll().size() > 0 ;
    }

    @Test
    public void createPolicy() throws ConstraintsViolationException {
        PolicyDo policyDo = new PolicyDo();
        CustomerDo customerDo = new CustomerDo();
        customerDo.setId(1l);
        policyDo.setCustomer(customerDo);
        policyDo.setPremium(new BigDecimal(121));
        policyDo.setCover(new BigDecimal(12122));
        assert policyService.create(policyDo).getId() > 0;
    }

    @Test(expected = ConstraintsViolationException.class)
    public void createPolicyWithEmptyCustomer() throws ConstraintsViolationException {
        PolicyDo policyDo = new PolicyDo();
        policyDo.setPremium(new BigDecimal(121));
        policyDo.setCover(new BigDecimal(12122));
        policyService.create(policyDo);
    }

    @Test(expected = ConstraintsViolationException.class)
    public void createPolicyWithInvalidCustomer() throws ConstraintsViolationException {
        PolicyDo policyDo = new PolicyDo();
        CustomerDo customerDo = new CustomerDo();
        customerDo.setId(12l);
        policyDo.setPremium(new BigDecimal(121));
        policyDo.setCover(new BigDecimal(12122));
        policyService.create(policyDo);
    }

}
