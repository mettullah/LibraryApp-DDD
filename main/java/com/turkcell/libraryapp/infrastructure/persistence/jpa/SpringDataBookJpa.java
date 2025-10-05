
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookJpa extends JpaRepository<BookEntity, Long> { 
    java.util.Optional<BookEntity> findByIsbn(String isbn);
}
