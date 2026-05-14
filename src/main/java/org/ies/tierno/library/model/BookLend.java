package org.ies.tierno.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookLend {
    private String nif;
    private long isbn;
    private LocalDate lendDate;
    private LocalDate returnDate;

}
