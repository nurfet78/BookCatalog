package org.nurfet.bookcatalog.repository;

import org.nurfet.bookcatalog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = :authorId")
    Optional<Author> findAuthorByIdAndAndBooks(@Param("authorId") Long authorId);
}
