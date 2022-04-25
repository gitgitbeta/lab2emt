package mk.ukim.finki.emt.lab2.service;

import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.dto.BookDto;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, CategoryBook category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, CategoryBook category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);
}
