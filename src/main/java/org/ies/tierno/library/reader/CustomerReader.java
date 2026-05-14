package org.ies.tierno.library.reader;

import lombok.AllArgsConstructor;
import org.ies.tierno.library.model.Book;
import org.ies.tierno.library.model.Customer;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CustomerReader implements Reader<Customer> {
    private final Random random;

    @Override
    public Customer read() {
        return new Customer(
                random.nextLong(10000000, 99999999) +"X",
                "Nombre " + random.nextLong(),
                "Apellidos " + random.nextLong(),
                random.nextInt(),
                random.nextInt(10000, 50000)
        );
    }
}
