package com.democrance.domainobject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")
@Data
public class CustomerDo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "created_date")
    private Timestamp createDateTime;

    @Column(name = "updated_date")
    private Timestamp updateDateTime;

}