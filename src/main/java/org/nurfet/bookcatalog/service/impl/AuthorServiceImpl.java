package org.nurfet.bookcatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.nurfet.bookcatalog.exception.NotFoundException;
import org.nurfet.bookcatalog.model.Author;
import org.nurfet.bookcatalog.repository.AuthorRepository;
import org.nurfet.bookcatalog.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Author findAuthorByIdAndAndBooks(Long id) {
        return authorRepository.findAuthorByIdAndAndBooks(id)
                .orElseThrow(() -> new NotFoundException(Author.class, id));
    }
}
