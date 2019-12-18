package com.democrance.controller;

import com.democrance.controller.mapper.PolicyMapper;
import com.democrance.datatransferobject.PolicyDto;
import com.democrance.exception.ConstraintsViolationException;
import com.democrance.exception.EntityNotFoundException;
import com.democrance.service.policy.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<PolicyDto>> getAllPolicies() {
        return new ResponseEntity<>(PolicyMapper.makePolicyDtoList(policyService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{policyId}")
    public ResponseEntity<PolicyDto> getCustomer( @PathVariable(name = "policyId") Long policyId) throws EntityNotFoundException {
        return new ResponseEntity<>(PolicyMapper.makePolicyDto(policyService.find(policyId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PolicyDto> createCar( @RequestBody PolicyDto policyDto) throws ConstraintsViolationException {
        return new ResponseEntity<>(PolicyMapper.makePolicyDto(
                policyService.create(
                        PolicyMapper.makePolicyDo(policyDto))), HttpStatus.CREATED);
    }
}
