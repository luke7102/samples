package com.luke.samples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Assumption Test")
public class AssumptionTests {

    @Test
    @DisplayName("assumeTrue test only Linux")
    public void testOnlyLinux() {
        assumeTrue(System.getProperty("os.name").startsWith("Linux"), "OS is not Linux.");
        assertEquals(2, 2);
    }

    @Test
    @DisplayName("assumingThat test")
    public void assumingThatTest() {
        assumingThat(System.getProperty("os.name").startsWith("Windows"), () -> assertEquals(1, 2));
    }
}
