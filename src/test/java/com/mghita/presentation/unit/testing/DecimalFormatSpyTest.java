package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class DecimalFormatSpyTest {

    @Test
    public void test() {
        DecimalFormat decimalFormat = spy(new DecimalFormat());
        assertEquals("42", decimalFormat.format(42L));
    }
}
