
package com.turkcell.libraryapp.domain.model;

import java.util.Objects;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private boolean active = true;

    public Book(Long id, String title, String isbn) {
        this.id = id; this.title = title; this.isbn = isbn;
    }
    public Long getId(){ return id; }
    public String getTitle(){ return title; }
    public String getIsbn(){ return isbn; }
    public boolean isActive(){ return active; }
    public void deactivate(){ this.active = false; }

    @Override public boolean equals(Object o){ if(this==o) return true; if(!(o instanceof Book)) return false; Book b=(Book)o; return Objects.equals(isbn,b.isbn); }
    @Override public int hashCode(){ return Objects.hash(isbn); }
}
