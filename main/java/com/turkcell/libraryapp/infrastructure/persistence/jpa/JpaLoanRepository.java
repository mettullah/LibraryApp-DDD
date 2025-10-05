
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import com.turkcell.libraryapp.domain.repository.LoanRepository;
import com.turkcell.libraryapp.domain.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaLoanRepository implements LoanRepository {
    private final SpringDataLoanJpa jpa;
    public JpaLoanRepository(SpringDataLoanJpa jpa){ this.jpa = jpa; }

    @Override public Loan save(Loan loan){
        LoanEntity e;
        if(loan.getId()==null){ e = new LoanEntity(loan.getCopyBookId(), loan.getStudentId(), loan.getLoanDate(), loan.getDueDate()); }
        else { e = jpa.findById(loan.getId()).orElse(new LoanEntity(loan.getCopyBookId(), loan.getStudentId(), loan.getLoanDate(), loan.getDueDate())); }
        e.setReturnDate(loan.getReturnDate());
        e.setReturned(loan.isReturned());
        e = jpa.save(e);
        return new Loan(e.getId(), e.getCopyBookId(), e.getStudentId(), e.getLoanDate(), e.getDueDate());
    }

    @Override public Optional<Loan> findById(Long id){ return jpa.findById(id).map(e -> new Loan(e.getId(), e.getCopyBookId(), e.getStudentId(), e.getLoanDate(), e.getDueDate())); }

    @Override public List<Loan> findByStudentId(Long studentId){ return jpa.findByStudentId(studentId).stream().map(e -> new Loan(e.getId(), e.getCopyBookId(), e.getStudentId(), e.getLoanDate(), e.getDueDate())).collect(Collectors.toList()); }
}
