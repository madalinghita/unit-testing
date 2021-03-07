package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DDecimalFormatSpyTest {

    @Test
    public void test() {
        DecimalFormat decimalFormat = spy(new DecimalFormat());
        assertEquals("42", decimalFormat.format(42L));
//        verify(decimalFormat).format(42L);
//        verify(decimalFormat).format(42L, any(), any());
        verify(decimalFormat).format(eq(42L), any(), any());
    }
}
