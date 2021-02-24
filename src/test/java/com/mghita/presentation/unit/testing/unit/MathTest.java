package com.mghita.presentation.unit.testing.unit;

import com.mghita.presentation.unit.testing.util.Math;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    private Math math;

    @BeforeEach
    void setUp() {
        math = new Math();
    }

    @Test
    void sum() {
        double result = math.sum(4, 7);
        assertEquals(11, result, "The sum is not correct!");
    }

    @Test
    void isPrime() {
        assertTrue(math.isPrime(13), "The number should be prime");
        assertFalse(math.isPrime(8), "The number should not be prime");
    }
}
