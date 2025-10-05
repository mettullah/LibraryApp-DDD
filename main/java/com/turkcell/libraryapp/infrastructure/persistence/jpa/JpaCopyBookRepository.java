
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import com.turkcell.libraryapp.domain.repository.CopyBookRepository;
import com.turkcell.libraryapp.domain.model.CopyBook;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaCopyBookRepository implements CopyBookRepository {
    private final SpringDataCopyBookJpa jpa;
    public JpaCopyBookRepository(SpringDataCopyBookJpa jpa){ this.jpa = jpa; }

    @Override public CopyBook save(CopyBook copy){
        CopyBookEntity e = new CopyBookEntity(copy.getBookId());
        e.setAvailable(copy.isAvailable());
        e = jpa.save(e);
        return new CopyBook(e.getId(), e.getBookId());
    }

    @Override public Optional<CopyBook> findById(Long id){ return jpa.findById(id).map(e -> new CopyBook(e.getId(), e.getBookId())); }

    @Override public List<CopyBook> findByBookId(Long bookId){ return jpa.findByBookId(bookId).stream().map(e -> new CopyBook(e.getId(), e.getBookId())).collect(Collectors.toList()); }
}
