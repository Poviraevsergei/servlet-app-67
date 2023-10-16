package com.tms.hibernate_lesson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity(name = "author")
public class Author {
    @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @Id
    private Integer id;

    @Column(name = "author_name")
    private String authorName;
}
