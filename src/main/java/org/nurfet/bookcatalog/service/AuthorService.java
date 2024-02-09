package org.nurfet.bookcatalog.service;

import org.nurfet.bookcatalog.model.Author;

import java.util.List;

public interface AuthorService {

    Author saveAuthor(Author author);

    List<Author> getAllAuthors();

    Author findAuthorByIdAndAndBooks(Long id);
}
