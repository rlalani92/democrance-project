package com.democrance.domainobject;

import com.democrance.domainvalue.PolicyType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "policy")
@Data
public class PolicyDo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "policy_type")
    private PolicyType policyType;

    @Column(name = "premium")
    private BigDecimal premium;

    @Column(name = "cover")
    private BigDecimal cover;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerDo customer;

    @Column(name = "created_date")
    private Timestamp createDateTime;

    @Column(name = "updated_date")
    private Timestamp updateDateTime;

}
