package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.*;

import java.io.IOException;

public class AJunit5Test {

    @BeforeAll
    public static void runsBeforeEverything() {
        System.out.println("Before Running a Test Class");
    }

    @BeforeEach
    public void runsBeforeEveryMethod() {
        System.out.println("Before Running a Test Method");
    }

    @Test
    public void aTestMethodAssertingTrue() {
        Assertions.assertTrue(true);
    }

    @DisplayName("SHIELD test")
    @Test
    public void aTestMethodAssertingEquals() {
        String expected = "bob";
        Assertions.assertEquals(expected, "bob");
    }

    @Test
    public void aTestMethodAssertingWithMessage() {
        String expected = "bob";
        Assertions.assertEquals(expected, "bob", "Because we always expect bob");
    }

    @Disabled("because if this ran it would fail")
    @Test
    public void anIgnoredDisabledTest() {
        Assertions.assertFalse(true);
    }

    @Test
    public void shouldThrowAnCheckedException() {
        Assertions.assertThrows(IOException.class, () -> {
            throw new IOException("We interrupt this test to throw an checked exception");
        });
    }

    @Test
    public void shouldThrowAnRuntimeException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("We interrupt this test to throw an runtime exception");
        });
    }

    @Test
    public void shouldNotThrowAnException() {
        Assertions.assertDoesNotThrow(() -> {
            System.out.println("Does not throw an Exception.");
        });
    }

    @AfterEach
    public void runsAfterEveryMethod() {
        System.out.println("After Finished Running a Test Method");
    }

    @AfterAll
    public static void runsAfterEverything() {
        System.out.println("After Finished Running a Test Class");
    }
}
