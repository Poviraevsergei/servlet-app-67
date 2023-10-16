package com.tms.hibernate_lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = "pages")
@EqualsAndHashCode(exclude = "pages")
@Entity(name = "books")
public class Book {
    @SequenceGenerator(name = "books_generator", sequenceName = "books_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_generator")
    @Id
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Collection<Page> pages;
}