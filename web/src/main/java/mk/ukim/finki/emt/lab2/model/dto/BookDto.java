package mk.ukim.finki.emt.lab2.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

@Data
public class BookDto {

    private String name;
    private CategoryBook  category;
    private Long author;
    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, CategoryBook category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
