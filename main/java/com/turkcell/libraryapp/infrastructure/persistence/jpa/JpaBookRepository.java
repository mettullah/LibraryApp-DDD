
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import com.turkcell.libraryapp.domain.repository.BookRepository;
import com.turkcell.libraryapp.domain.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaBookRepository implements BookRepository {
    private final SpringDataBookJpa jpa;
    public JpaBookRepository(SpringDataBookJpa jpa){ this.jpa = jpa; }

    @Override
    public Book save(Book book){
        BookEntity e = new BookEntity(book.getTitle(), book.getIsbn());
        e.setActive(book.isActive());
        e = jpa.save(e);
        return new Book(e.getId(), e.getTitle(), e.getIsbn());
    }

    @Override
    public Optional<Book> findById(Long id){ return jpa.findById(id).map(e -> new Book(e.getId(), e.getTitle(), e.getIsbn())); }

    @Override
    public Optional<Book> findByIsbn(String isbn){ return jpa.findByIsbn(isbn).map(e -> new Book(e.getId(), e.getTitle(), e.getIsbn())); }

    @Override
    public List<Book> findAll(){ return jpa.findAll().stream().map(e -> new Book(e.getId(), e.getTitle(), e.getIsbn())).collect(Collectors.toList()); }
}
