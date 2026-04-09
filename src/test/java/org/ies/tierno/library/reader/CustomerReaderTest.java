package org.ies.tierno.library.reader;

import org.ies.tierno.library.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class CustomerReaderTest {
    @Mock
    private Random random;

    @InjectMocks
    private CustomerReader customerReader;

    @Test
    public void readTest() {

        when(random.nextLong(10000000, 99999999))
                .thenReturn(10000000L);

        when(random.nextLong())
                .thenReturn(10L)
                .thenReturn(11L);

        when(random.nextInt())
                .thenReturn(5);

        when(random.nextInt(10000, 50000))
                .thenReturn(10001);

        Customer res = customerReader.read();

        Customer expected = new Customer(
                "10000000X",
                "Nombre 10",
                "Apellidos 11",
                5,
                10001
        );

        Assertions.assertEquals(expected, res);
    }

}
