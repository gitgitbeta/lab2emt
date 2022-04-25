package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.dto.BookDto;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;
import mk.ukim.finki.emt.lab2.model.exceptions.AuthorNotFound;
import mk.ukim.finki.emt.lab2.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.lab2.repository.jpa.*;
import mk.ukim.finki.emt.lab2.service.BookService;
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


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, CategoryBook category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFound(authorId));

        this.bookRepository.deleteByName(name);
        Book book = new Book(name,category,author,availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, CategoryBook category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        book.setName(name);
        book.setAvailableCopies(availableCopies);
        book.setCategory(category);

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFound(authorId));
        book.setAuthor(author);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        book.setAuthor(author);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
            this.bookRepository.deleteById(id);
    }

}
