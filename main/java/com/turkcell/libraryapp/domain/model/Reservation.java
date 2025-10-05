
package com.turkcell.libraryapp.domain.model;

import java.time.LocalDateTime;

public class Reservation {
    private Long id;
    private Long bookId;
    private Long studentId;
    private LocalDateTime createdAt;

    public Reservation(Long id, Long bookId, Long studentId, LocalDateTime createdAt){
        this.id=id; this.bookId=bookId; this.studentId=studentId; this.createdAt=createdAt;
    }
    public Long getId(){ return id; }
    public Long getBookId(){ return bookId; }
    public Long getStudentId(){ return studentId; }
}
