package mk.ukim.finki.emt.lab2.model;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;
import javax.persistence.*;

@Data
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryBook category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(){}
    public Book( String name, CategoryBook category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(CategoryBook category) {
        this.category = category;
    }

    public CategoryBook getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }


}
