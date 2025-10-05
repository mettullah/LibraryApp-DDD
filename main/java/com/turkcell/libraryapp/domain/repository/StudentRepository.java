
package com.turkcell.libraryapp.domain.repository;

import com.turkcell.libraryapp.domain.model.Student;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student s);
    Optional<Student> findById(Long id);
}
