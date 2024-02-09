package org.nurfet.bookcatalog.service;

import org.nurfet.bookcatalog.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book saveBook(Book book);
    void addBookToAuthor(Long authorId, Book book);
}
