
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(name="copy_books")
public class CopyBookEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private boolean available = true;
    public CopyBookEntity(){}
    public CopyBookEntity(Long bookId){ this.bookId = bookId; }
    public Long getId(){ return id; }
    public Long getBookId(){ return bookId; }
    public boolean isAvailable(){ return available; }
    public void setAvailable(boolean a){ this.available=a; }
    public void setBookId(Long id){ this.bookId = id; }
}
