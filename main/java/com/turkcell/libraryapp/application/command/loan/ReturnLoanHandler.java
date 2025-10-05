
package com.turkcell.libraryapp.application.command.loan;

import com.turkcell.libraryapp.domain.repository.LoanRepository;
import com.turkcell.libraryapp.domain.repository.CopyBookRepository;
import com.turkcell.libraryapp.domain.model.Loan;
import com.turkcell.libraryapp.domain.model.CopyBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ReturnLoanHandler {
    private final LoanRepository loanRepo;
    private final CopyBookRepository copyRepo;

    public ReturnLoanHandler(LoanRepository loanRepo, CopyBookRepository copyRepo){
        this.loanRepo = loanRepo; this.copyRepo = copyRepo;
    }

    @Transactional
    public Loan handle(ReturnLoanCommand cmd){
        Loan loan = loanRepo.findById(cmd.loanId).orElseThrow(() -> new IllegalArgumentException("loan not found"));
        if(loan.isReturned()) throw new IllegalStateException("already returned");
        loan.markReturned(LocalDateTime.now());
        copyRepo.findById(loan.getCopyBookId()).ifPresent(c -> { c.markReturned(); copyRepo.save(c); });
        return loanRepo.save(loan);
    }
}
