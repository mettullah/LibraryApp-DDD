
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpringDataCopyBookJpa extends JpaRepository<CopyBookEntity, Long> {
    List<CopyBookEntity> findByBookId(Long bookId);
}
