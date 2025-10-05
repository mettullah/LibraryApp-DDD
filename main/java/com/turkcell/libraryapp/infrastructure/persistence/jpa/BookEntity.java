
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private boolean active = true;

    public BookEntity() {}
    public BookEntity(String title, String isbn){ this.title = title; this.isbn = isbn; }

    public Long getId(){ return id; }
    public String getTitle(){ return title; }
    public String getIsbn(){ return isbn; }
    public boolean isActive(){ return active; }

    public void setTitle(String t){ this.title=t; }
    public void setIsbn(String i){ this.isbn=i; }
    public void setActive(boolean a){ this.active=a; }
}
