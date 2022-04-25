package mk.ukim.finki.emt.lab2.service;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);
    List<Author> findAll();
    Optional<Author> save(String name, String surname, Country country);
    void deleteById(Long id);
}
