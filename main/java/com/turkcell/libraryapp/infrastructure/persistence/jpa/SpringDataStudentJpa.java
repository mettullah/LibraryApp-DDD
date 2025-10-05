
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStudentJpa extends JpaRepository<StudentEntity, Long> { }
