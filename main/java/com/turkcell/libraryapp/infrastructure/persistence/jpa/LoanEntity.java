
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="loans")
public class LoanEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long copyBookId;
    private Long studentId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private boolean returned = false;
    public LoanEntity(){}
    public LoanEntity(Long copyBookId, Long studentId, LocalDateTime loanDate, LocalDateTime dueDate){
        this.copyBookId = copyBookId; this.studentId = studentId; this.loanDate = loanDate; this.dueDate = dueDate;
    }
    public Long getId(){ return id; }
    public Long getCopyBookId(){ return copyBookId; }
    public Long getStudentId(){ return studentId; }
    public LocalDateTime getLoanDate(){ return loanDate; }
    public LocalDateTime getDueDate(){ return dueDate; }
    public LocalDateTime getReturnDate(){ return returnDate; }
    public boolean isReturned(){ return returned; }
    public void setReturnDate(LocalDateTime when){ this.returnDate = when; }
    public void setReturned(boolean r){ this.returned = r; }
    public void setCopyBookId(Long id){ this.copyBookId = id; }
    public void setStudentId(Long id){ this.studentId = id; }
}
