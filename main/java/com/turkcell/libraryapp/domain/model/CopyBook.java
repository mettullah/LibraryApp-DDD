
package com.turkcell.libraryapp.domain/model;

public class CopyBook {
    private Long id;
    private Long bookId;
    private boolean available = true;

    public CopyBook(Long id, Long bookId){ this.id=id; this.bookId=bookId; }
    public Long getId(){ return id; }
    public Long getBookId(){ return bookId; }
    public boolean isAvailable(){ return available; }
    public void markBorrowed(){ this.available=false; }
    public void markReturned(){ this.available=true; }
}
