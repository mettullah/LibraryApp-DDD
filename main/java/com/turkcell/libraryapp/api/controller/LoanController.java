
package com.turkcell.libraryapp.api.controller;

import com.turkcell.libraryapp.application.command.loan.CreateLoanCommand;
import com.turkcell.libraryapp.application.command.loan.CreateLoanHandler;
import com.turkcell.libraryapp.application.command.loan.ReturnLoanCommand;
import com.turkcell.libraryapp.application.command.loan.ReturnLoanHandler;
import com.turkcell.libraryapp.domain.model.Loan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final CreateLoanHandler createLoanHandler;
    private final ReturnLoanHandler returnLoanHandler;

    public LoanController(CreateLoanHandler createLoanHandler, ReturnLoanHandler returnLoanHandler){
        this.createLoanHandler = createLoanHandler; this.returnLoanHandler = returnLoanHandler;
    }

    @PostMapping("/loans")
    public Loan createLoan(@RequestBody CreateLoanRequest r){
        return createLoanHandler.handle(new CreateLoanCommand(r.studentId, r.copyBookId));
    }

    @PostMapping("/returns")
    public Loan returnLoan(@RequestBody ReturnLoanRequest r){
        return returnLoanHandler.handle(new ReturnLoanCommand(r.loanId));
    }

    public static class CreateLoanRequest{ public Long studentId; public Long copyBookId; }
    public static class ReturnLoanRequest{ public Long loanId; }
}
