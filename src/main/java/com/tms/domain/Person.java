package com.tms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
public class Person {
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;
    private Boolean isMarried;
    private Timestamp created;
}
