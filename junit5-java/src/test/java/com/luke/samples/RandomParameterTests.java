package com.luke.samples;

import com.luke.samples.ext.RandomParameterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.luke.samples.ext.RandomParameterExtension.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith({RandomParameterExtension.class})
public class RandomParameterTests {

    @Test
    void injectInteger(@Random int i, @Random int j) {
        assertNotEquals(i, j);
    }

    @Test
    void injectsDouble(@Random double d) {
        assertEquals(0.0, d, 1.0);
    }
}
