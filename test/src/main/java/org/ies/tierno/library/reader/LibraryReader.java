package org.ies.tierno.library.reader;

import lombok.AllArgsConstructor;
import org.ies.tierno.library.model.Book;
import org.ies.tierno.library.model.BookLend;
import org.ies.tierno.library.model.Customer;
import org.ies.tierno.library.model.Library;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
public class LibraryReader implements Reader<Library> {
    private final Random random;
    private final Reader<Book> bookReader;
    private final Reader<Customer> customerReader;

    @Override
    public Library read() {
        int numBooks = random.nextInt(1, 10);
        Map<Long, Book> booksByIsbn = new HashMap<>();
        for (int i = 0; i < numBooks; i++) {
            var book = bookReader.read();
            booksByIsbn.put(book.getIsbn(), book);
        }

        int numCustomers = random.nextInt(1, 10);
        Map<String, Customer> customersByNif = new HashMap<>();
        for (int i = 0; i < numCustomers; i++) {
            var customer = customerReader.read();
            customersByNif.put(customer.getNif(), customer);
        }
        List<BookLend> bookLends = new ArrayList<>();
        int numBookLends = random.nextInt(1, 5);
        for (int i = 0; i < numBookLends; i++) {
            var timestamp = random.nextLong(10000L, 1000000L);
            BookLend bookLend = new BookLend(
                    customersByNif.values().stream().toList().get(random.nextInt(numCustomers)).getNif(),
                    booksByIsbn.values().stream().toList().get(random.nextInt(numBooks)).getIsbn(),
                    LocalDate.ofEpochDay(timestamp),
                    LocalDate.ofEpochDay(timestamp + 86400000)
            );
            bookLends.add(bookLend);
        }
        return new Library(
                "Biblioteca " + random.nextLong(),
                booksByIsbn,
                customersByNif,
                bookLends
        );
    }
}
