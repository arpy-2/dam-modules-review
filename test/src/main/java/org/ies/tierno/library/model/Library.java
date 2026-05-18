package org.ies.tierno.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.library.exceptions.BookNotFoundException;
import org.ies.tierno.library.exceptions.CustomerNotFoundException;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Library {
    private String name;
    private Map<Long, Book> booksByIsbn;
    private Map<String, Customer> customersByNif;
    private List<BookLend> bookLends;

    public void showBooks() {
        booksByIsbn.values().stream().forEach(book -> book.showInfo());
    }

    public void showCustomers() {
        customersByNif.values().stream().forEach(customer -> customer.showInfo());
    }

    public Book findBook(long isbn) throws BookNotFoundException {
        if (booksByIsbn.containsKey(isbn)) {
            return booksByIsbn.get(isbn);
        } else {
            throw new BookNotFoundException(isbn);
        }
    }

    public Customer findCustomer(String nif) throws CustomerNotFoundException {
        if (customersByNif.containsKey(nif)) {
            return customersByNif.get(nif);
        } else {
            throw new CustomerNotFoundException(nif);
        }
    }

    public boolean existsBookLend(long isbn, String nif) throws BookNotFoundException, CustomerNotFoundException {
        findBook(isbn);
        findCustomer(nif);

        // Si he llegado aquí es que existe el libro y el cliente
        for (var bookLend : bookLends) {
            if (bookLend.getIsbn() == isbn && bookLend.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }
}
