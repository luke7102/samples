package com.luke.samples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Assertion Test")
public class AssertionTests {

    @Test
    @DisplayName("assertArrayEquals test")
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = {'J', 'u', 'p', 'i', 't', 'e', 'r'};
        char[] actual = "Kupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    @DisplayName("assertEquals test")
    public void whenAssertingEquality_thenEqual() {
        int square = 2 * 2;
        int rectangle = 2 * 3;

        assertEquals(square, rectangle, "square and rectangle area should be equal");
    }

    @Test
    @DisplayName("assertEquals test with delta")
    public void whenAssertingEqualityWithDelta_thenEqual() {
        float square = 2 * 2;
        float rectangle = 2 * 4;
        float delta = 3;

        assertEquals(square, rectangle, delta, "square and rectangle area should be equal within the delta");
    }

    @Test
    @DisplayName("assertNotEquals test")
    public void whenAssertingEquality_thenNotEqual() {
        Integer resultValue = 0;

        assertNotEquals(0, resultValue, "The result cannot be 0");
    }

    @Test
    @DisplayName("assertTrue test")
    public void whenAssertingConditions_thenVerified() {
        assertTrue(5 < 4, "5 is greater then 4");
    }

    @Test
    @DisplayName("assertFalse test with supplier")
    public void givenBooleanSupplier_whenAssertingCondition_thenVerified() {
        BooleanSupplier condition = () -> 5 < 6;

        assertFalse(condition, "5 is not greater then 6");
    }

    @Test
    @DisplayName("assertNull test")
    public void whenAssertingNull_thenTrue() {
        Object cat = new Object();

        assertNull(cat, "The cat should be null");
    }

    @Test
    @DisplayName("assertNotNull test")
    public void whenAssertingNotNull_thenTrue() {
        Object dog = new Object();

        assertNotNull(dog, "The dog should not be null");
    }

    @Test
    @DisplayName("assertSame test")
    public void whenAssertingSameObject_thenSuccess() {
        Integer intA = new Integer("1");
        Integer intB = new Integer("1");

        // assertEquals(intA, intB, "intA and intB should be same"); // Success
        assertSame(intA, intB, "intA and intB should be same"); // Fail
    }

    @Test
    @DisplayName("fail test")
    public void whenFailingATest_thenFailed() {
        // development is not completed
        fail("FAIL - development is not completed");
    }

    @Test
    @DisplayName("assertAll test")
    public void givenMultipleAssertion_whenAssertingAll_thenOK() {
        assertAll("grouped assertions test",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("ava", "JAVA".toLowerCase()),
                () -> assertTrue(5 > 4, "5 is greater then 4")
        );
    }

    @Test
    @DisplayName("assertIterableEquals test")
    public void givenTwoLists_whenAssertingIterables_thenEquals() {
        Iterable<String> listOne = new ArrayList<>(asList("Java", "JUnit", "Test"));
        Iterable<String> listTwo = new LinkedList<>(asList("Java", "Unit", "Test"));

        assertIterableEquals(listOne, listTwo, "listOne should be equal to listTwo");
    }

    @Test
    @DisplayName("assertLinesMatch test")
    public void whenAssertingEqualityListOfStrings_thenEqual() {
        List<String> expected = asList("Java", "\\d+", "JUnit");
        List<String> actual = asList("Java", "j11", "JUnit");

        assertLinesMatch(expected, actual, "expected should be matched actual");
    }

    @Test
    @DisplayName("assertThrows test")
    public void whenAssertingException_thenThrown() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    throw new ClassNotFoundException("Class Not Found Exception Message");
                }
        );

        assertEquals("IllegalArgument Exception Message", exception.getMessage());
    }

    @Test
    @DisplayName("assertTimeout test")
    public void whenAssertingTimeout_thenNotExceeded() {
        assertTimeout(
                Duration.ofSeconds(1),
                () -> {
                    System.out.println("Start Testing...");
                    Thread.sleep(3000);
                    System.out.println("End Testing...");
                }
        );
    }

    @Test
    @DisplayName("assertTimeoutPreemptively test")
    public void whenAssertingTimeoutPreemptively_thenNotExceeded() {
        assertTimeoutPreemptively(
                Duration.ofSeconds(1),
                () -> {
                    System.out.println("Start Testing...");
                    Thread.sleep(3000);
                    System.out.println("End Testing...");
                }
        );
    }
}
