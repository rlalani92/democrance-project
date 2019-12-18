package com.democrance.datatransferobject;

import com.democrance.domainvalue.PolicyType;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class PolicyDto {

    private Long id;
    private PolicyType policyType;
    private BigDecimal premium;
    private BigDecimal cover;
    private CustomerDto customerDto;
    private Date createdDate;
    private Date lastUpdatedDate;

}
