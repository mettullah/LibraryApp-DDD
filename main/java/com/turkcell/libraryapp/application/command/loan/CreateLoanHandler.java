
package com.turkcell.libraryapp.application.command.loan;

import com.turkcell.libraryapp.domain.repository.CopyBookRepository;
import com.turkcell.libraryapp.domain.repository.LoanRepository;
import com.turkcell.libraryapp.domain.repository.StudentRepository;
import com.turkcell.libraryapp.domain.model.Loan;
import com.turkcell.libraryapp.domain.model.CopyBook;
import com.turkcell.libraryapp.domain.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CreateLoanHandler {
    private final LoanRepository loanRepo;
    private final CopyBookRepository copyRepo;
    private final StudentRepository studentRepo;

    public CreateLoanHandler(LoanRepository loanRepo, CopyBookRepository copyRepo, StudentRepository studentRepo){
        this.loanRepo = loanRepo; this.copyRepo = copyRepo; this.studentRepo = studentRepo;
    }

    @Transactional
    public Loan handle(CreateLoanCommand cmd){
        CopyBook copy = copyRepo.findById(cmd.copyBookId).orElseThrow(() -> new IllegalArgumentException("copy not found"));
        if(!copy.isAvailable()) throw new IllegalStateException("copy not available");
        Student student = studentRepo.findById(cmd.studentId).orElseThrow(() -> new IllegalArgumentException("student not found"));
        LocalDateTime now = LocalDateTime.now();
        Loan loan = new Loan(null, copy.getId(), student.getId(), now, now.plusDays(14));
        copy.markBorrowed();
        copyRepo.save(copy);
        return loanRepo.save(loan);
    }
}
