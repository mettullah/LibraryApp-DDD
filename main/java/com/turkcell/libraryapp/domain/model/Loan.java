
package com.turkcell.libraryapp.domain.model;

import java.time.LocalDateTime;

public class Loan {
    private Long id;
    private Long copyBookId;
    private Long studentId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private boolean returned = false;

    public Loan(Long id, Long copyBookId, Long studentId, LocalDateTime loanDate, LocalDateTime dueDate){
        this.id=id; this.copyBookId=copyBookId; this.studentId=studentId; this.loanDate=loanDate; this.dueDate=dueDate;
    }
    public Long getId(){ return id; }
    public Long getCopyBookId(){ return copyBookId; }
    public Long getStudentId(){ return studentId; }
    public LocalDateTime getLoanDate(){ return loanDate; }
    public LocalDateTime getDueDate(){ return dueDate; }
    public LocalDateTime getReturnDate(){ return returnDate; }
    public boolean isReturned(){ return returned; }

    public void markReturned(LocalDateTime when){ this.returned=true; this.returnDate=when; }
}
