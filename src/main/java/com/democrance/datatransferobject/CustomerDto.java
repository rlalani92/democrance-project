package com.democrance.datatransferobject;

import lombok.Data;

import java.sql.Date;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
}