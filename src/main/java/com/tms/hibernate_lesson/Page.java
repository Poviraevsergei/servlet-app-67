package com.tms.hibernate_lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = "book")
@EqualsAndHashCode(exclude = "book")
@Entity(name = "pages")
public class Page {
    @SequenceGenerator(name = "pages_generator", sequenceName = "pages_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_generator")
    @Id
    private Integer id;

    @Column(name = "text")
    private String text;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
