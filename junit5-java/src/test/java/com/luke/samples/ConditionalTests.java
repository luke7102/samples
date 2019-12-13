package com.luke.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.*;

public class ConditionalTests {

    @Test
    @EnabledOnOs(WINDOWS)
    public void onlyOnWindowsOS() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledOnOs(MAC)
    public void onlyOnMacOS() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledOnOs({MAC, WINDOWS})
    public void onlyOnWindowsMacOS() {
        assertEquals(2, 3);
    }

    @Test
    @DisabledOnOs(MAC)
    public void notOnMacOS() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledOnJre(JAVA_8)
    public void onlyOnJava8() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledOnJre({JAVA_8, JAVA_11})
    public void onJava8Or11() {
        assertEquals(2, 3);
    }

    @Test
    @DisabledOnJre(JAVA_8)
    public void notOnJava8() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    public void onlyOn64BitArchitectures() {
        assertEquals(2, 3);
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    public void notOnCiServer() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledIfSystemProperty(named = "build-server", matches = "true")
    public void onBuildServer() {
        assertEquals(2, 3);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    public void onlyOnStagingServer() {
        assertEquals(2, 3);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    public void notOnDeveloperWorkstation() {
        assertEquals(2, 3);
    }
}
