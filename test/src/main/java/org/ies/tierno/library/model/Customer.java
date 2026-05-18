package org.ies.tierno.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Data
@AllArgsConstructor
public class Customer {
    private String nif;
    private String name;
    private String surname;
    private int number;
    private int zipCode;

    public void showInfo() {
        log.info(surname + ", " + name + " (" + nif + "): Num socio " + number + ", código postal " + zipCode);
    }
}
