package com.luke.samples;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.MethodOrderer.*;

@TestMethodOrder(OrderAnnotation.class)
//@TestMethodOrder(Alphanumeric.class)
public class OrderTests {

    @Test
    @Order(3)
    void testOne() {
        assertEquals(3, 3);
    }

    @Test
    @Order(1)
    void testTwo() {
        assertEquals(3, 3);
    }

    @Test
    @Order(2)
    void testThree() {
        assertEquals(3, 3);
    }
}
