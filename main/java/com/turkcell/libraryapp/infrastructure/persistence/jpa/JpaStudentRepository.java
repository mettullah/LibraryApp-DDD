
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import com.turkcell.libraryapp.domain.repository.StudentRepository;
import com.turkcell.libraryapp.domain.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaStudentRepository implements StudentRepository {
    private final SpringDataStudentJpa jpa;
    public JpaStudentRepository(SpringDataStudentJpa jpa){ this.jpa = jpa; }

    @Override public Student save(Student s){
        StudentEntity e = new StudentEntity(s.getName());
        e = jpa.save(e);
        return new Student(e.getId(), e.getName());
    }

    @Override public Optional<Student> findById(Long id){ return jpa.findById(id).map(e -> new Student(e.getId(), e.getName())); }
}
