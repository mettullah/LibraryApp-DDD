
package com.turkcell.libraryapp.domain.repository;

import com.turkcell.libraryapp.domain.model.CopyBook;
import java.util.Optional;
import java.util.List;

public interface CopyBookRepository {
    CopyBook save(CopyBook copy);
    Optional<CopyBook> findById(Long id);
    List<CopyBook> findByBookId(Long bookId);
}
