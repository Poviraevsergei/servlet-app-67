package com.tms.security.domain.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String firstName;
    private String secondName;
    private Integer age;
    private Boolean isMarried;
    private String personLogin;
    private String personPassword;
}
