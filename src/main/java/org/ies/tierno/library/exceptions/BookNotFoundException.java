package org.ies.tierno.library.exceptions;

public class BookNotFoundException extends Exception {
    private final long isbn;

    public BookNotFoundException(long isbn) {
        super("ISBN: " + isbn);
        this.isbn = isbn;
    }

    public long getIsbn() {
        return isbn;
    }
}
