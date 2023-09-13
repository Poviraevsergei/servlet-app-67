package com.tms.domain;

import com.tms.validation.Email67;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Getter
@ToString
@Setter
public class Person {
    private Long id;
    @Size(min = 2, max = 20)
    private String firstName;
    @Pattern(regexp = "[A-z]*")
    private String secondName;
    @Min(value = 18)
    @Max(value = 120)
    private Integer age;
    @Email67
    private String email;
    private Boolean isMarried;
    private Timestamp created;
    private Role role;
}
