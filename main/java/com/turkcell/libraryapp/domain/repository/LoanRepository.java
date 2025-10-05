
package com.turkcell.libraryapp.domain.repository;

import com.turkcell.libraryapp.domain.model.Loan;
import java.util.Optional;
import java.util.List;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findByStudentId(Long studentId);
}
