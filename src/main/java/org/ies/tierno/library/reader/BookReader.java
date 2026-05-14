package org.ies.tierno.library.reader;

import lombok.AllArgsConstructor;
import org.ies.tierno.library.model.Book;
import org.ies.tierno.library.model.BookLend;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class BookReader implements Reader<Book> {
    private final Random random;

    @Override
    public Book read() {
        return new Book(
                random.nextLong(10000, 10000000),
                "Título " + random.nextLong(),
                "Autor " + random.nextLong(),
                List.of("Novela")
        );
    }
}
