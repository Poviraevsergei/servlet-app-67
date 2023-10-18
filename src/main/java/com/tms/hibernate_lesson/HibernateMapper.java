package com.tms.hibernate_lesson;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HibernateMapper {

    public Book getNormalBook(Book book) {
        book.getAuthors().forEach(author -> author.setBooks(null));
        return book;
    }

    public Author getNormalAuthor(Author author) {
        author.getBooks().forEach(book -> book.setAuthors(null));
        return author;
    }
}