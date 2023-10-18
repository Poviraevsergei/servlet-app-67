package com.tms.hibernate_lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookRepository bookRepository;
    private final HibernateMapper hibernateMapper;

    public BookController(BookRepository bookRepository, HibernateMapper hibernateMapper) {
        this.bookRepository = bookRepository;
        this.hibernateMapper = hibernateMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = hibernateMapper.getNormalBook(bookRepository.findById(id));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateComponentById(@RequestBody Book book) {
        bookRepository.update(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody Book book) {
        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
