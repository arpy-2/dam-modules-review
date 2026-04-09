package org.ies.tierno.library.model;

import org.ies.tierno.library.exceptions.BookNotFoundException;
import org.ies.tierno.library.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class LibraryTests {


    @Test
    public void existsBookLendTrueTest() throws BookNotFoundException, CustomerNotFoundException {
        Library library = createTestLibrary();

        boolean exists = library.existsBookLend(1, "1X");

        Assertions.assertTrue(exists);
    }

    @Test
    public void existsBookLendFalseTest() throws BookNotFoundException, CustomerNotFoundException {
        Library library = createTestLibrary();

        boolean exists = library.existsBookLend(1, "2X");

        Assertions.assertFalse(exists);
    }

    @Test
    public void existsBookLendBookNotFoundTest() {
        Library library = createTestLibrary();

        Assertions.assertThrows(
                BookNotFoundException.class,
                () -> {
                    library.existsBookLend(1234, "2X");
                }
        );
    }

    @Test
    public void existsBookLendCustomerNotFoundTest() {
        Library library = createTestLibrary();

        Assertions.assertThrows(
                CustomerNotFoundException.class,
                () -> {
                    library.existsBookLend(1, "2234X");
                }
        );
    }


    private Library createTestLibrary() {
        return new Library("IES Tierno Galván", books(), customers(), bookLends());
    }

    private List<BookLend> bookLends() {
        return List.of(
                new BookLend("1X", 1, LocalDate.now(), LocalDate.now()),
                new BookLend("1X", 2, LocalDate.now(), LocalDate.now())
        );
    }

    private Map<String, Customer> customers() {
        return Map.of(
                "1X", new Customer("1X", "George", "Pig", 1, 28000),
                "2X", new Customer("2X", "Peppa", "Pig", 2, 28000)
        );
    }

    private Map<Long, Book> books() {
        return Map.of(
                1L, new Book(1L, "Programación en Java", "Bob Esponja", List.of("Programación", "Java")),
                2L, new Book(2L, "Programación en Kotlin", "Peppa Pig", List.of("Programación", "Kotlin"))
        );

    }
}
