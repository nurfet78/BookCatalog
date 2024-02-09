package org.nurfet.bookcatalog.db;

import lombok.RequiredArgsConstructor;
import org.nurfet.bookcatalog.model.Author;
import org.nurfet.bookcatalog.model.Book;
import org.nurfet.bookcatalog.service.AuthorService;
import org.nurfet.bookcatalog.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB implements CommandLineRunner {

    private final AuthorService authorService;

    private final BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Стив", "Макконнелл");
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book("Совершенный код. Мастер-класс"));
        books1.add(new Book("Сколько стоит программный проект"));
        books1.add(new Book("Еще более эффективный Agile"));

        addAuthorAndBooks(author1, books1);


        Author author2 = new Author("Мартин", "Фаулер");
        List<Book> books2 = new ArrayList<>();
        books2.add(new Book("Шаблоны корпоративных приложений"));
        books2.add(new Book("UML. Основы"));
        books2.add(new Book("Domain-Specific Languages"));

        addAuthorAndBooks(author2, books2);

    }

    private void addAuthorAndBooks(Author author, List<Book> books) {
        author.getBooks().add(books.get(0));
        author.getBooks().add(books.get(1));
        author.getBooks().add(books.get(2));

        authorService.saveAuthor(author);

        books.get(0).setAuthor(author);
        books.get(1).setAuthor(author);
        books.get(2).setAuthor(author);

        bookService.saveBook(books.get(0));
        bookService.saveBook(books.get(1));
        bookService.saveBook(books.get(2));
    }
}
