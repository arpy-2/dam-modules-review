package org.ies.tierno.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
@Data
@AllArgsConstructor
public class Book {
    private long isbn;
    private String title;
    private String author;
    private List<String> genres;

    public void showInfo() {
        log.info(title + "(" + isbn + ") - " + author + ": " + genres);
    }
}
