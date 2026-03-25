package org.ies.tierno.library.exceptions;

public class CustomerNotFoundException extends Exception {
    private final String nif;

    public CustomerNotFoundException(String nif) {
        super("ISBN: " + nif);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
