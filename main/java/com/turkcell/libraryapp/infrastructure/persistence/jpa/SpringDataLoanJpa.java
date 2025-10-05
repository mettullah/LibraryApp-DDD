
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpringDataLoanJpa extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findByStudentId(Long studentId);
}
