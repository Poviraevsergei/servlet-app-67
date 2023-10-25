package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
@Entity(name = "person")
public class Person {
    @Id
    @SequenceGenerator(name = "person_generator", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    private Long id;

    @Size(min = 2, max = 20)
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-z]*")
    @Column(name = "second_name")
    private String secondName;

    @Min(value = 18)
    @Max(value = 120)
    @Column(name = "age")
    private Integer age;
    @Column(name = "is_married")
    private Boolean isMarried;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Timestamp created;

}
