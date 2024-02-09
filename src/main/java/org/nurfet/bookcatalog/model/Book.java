package org.nurfet.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nurfet.bookcatalog.service.BookService;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book extends AbstractEntity<Long>{

    @Serial
    private static final long serialVersionUID = 2L;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;
    public Book(String title) {
        this.title = title;
    }
}
