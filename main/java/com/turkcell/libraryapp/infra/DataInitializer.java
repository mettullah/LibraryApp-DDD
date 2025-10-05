
package com.turkcell.libraryapp.infra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.SpringDataBookJpa;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.BookEntity;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.SpringDataCopyBookJpa;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.CopyBookEntity;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.SpringDataStudentJpa;
import com.turkcell.libraryapp.infrastructure.persistence.jpa.StudentEntity;

@Component
public class DataInitializer implements CommandLineRunner {
    private final SpringDataBookJpa bookJpa;
    private final SpringDataCopyBookJpa copyJpa;
    private final SpringDataStudentJpa studentJpa;

    public DataInitializer(SpringDataBookJpa bookJpa, SpringDataCopyBookJpa copyJpa, SpringDataStudentJpa studentJpa){
        this.bookJpa = bookJpa; this.copyJpa = copyJpa; this.studentJpa = studentJpa;
    }

    @Override
    public void run(String... args) throws Exception {
        BookEntity b1 = bookJpa.save(new BookEntity("Domain-Driven Design","978-0321125217"));
        BookEntity b2 = bookJpa.save(new BookEntity("Clean Code","978-0132350884"));
        copyJpa.save(new CopyBookEntity(b1.getId()));
        copyJpa.save(new CopyBookEntity(b1.getId()));
        copyJpa.save(new CopyBookEntity(b2.getId()));
        studentJpa.save(new StudentEntity("Mertcan"));
    }
}
