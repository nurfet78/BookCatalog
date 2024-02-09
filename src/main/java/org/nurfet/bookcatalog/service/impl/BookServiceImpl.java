package org.nurfet.bookcatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.nurfet.bookcatalog.exception.NotFoundException;
import org.nurfet.bookcatalog.model.Author;
import org.nurfet.bookcatalog.model.Book;
import org.nurfet.bookcatalog.repository.AuthorRepository;
import org.nurfet.bookcatalog.repository.BookRepository;
import org.nurfet.bookcatalog.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public void addBookToAuthor(Long authorId, Book book) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            book.setAuthor(author);
            bookRepository.save(book);
            author.getBooks().add(book);
            authorRepository.save(author);
        } else {
            throw new NotFoundException(Author.class, authorId);
        }
    }
}
