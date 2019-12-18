package com.democrance.service.policy;

import com.democrance.domainobject.PolicyDo;
import com.democrance.exception.ConstraintsViolationException;
import com.democrance.exception.EntityNotFoundException;

import java.util.List;

public interface PolicyService {

    List<PolicyDo> findAll();
    PolicyDo find(Long id) throws EntityNotFoundException;
    PolicyDo create(PolicyDo policyDo) throws ConstraintsViolationException;
}
