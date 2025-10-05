
package com.turkcell.libraryapp.api.controller;

import com.turkcell.libraryapp.domain.repository.BookRepository;
import com.turkcell.libraryapp.domain.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepo;
    private final AtomicLong idGen = new AtomicLong(1);

    public BookController(BookRepository bookRepo){ this.bookRepo = bookRepo; }

    @GetMapping
    public List<Book> all(){ return bookRepo.findAll(); }

    @PostMapping
    public Book create(@RequestBody CreateBookRequest r){
        Book b = new Book(idGen.getAndIncrement(), r.title, r.isbn);
        return bookRepo.save(b);
    }

    public static class CreateBookRequest{ public String title; public String isbn; }
}
