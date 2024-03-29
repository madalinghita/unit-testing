package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;

import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class BHowItWorksTest {

    @Test
    public void testSnippet() {
        // 1: create
        PasswordEncoder mock = mock(PasswordEncoder.class);

        // 2: stub
        when(mock.encode("a")).thenReturn("1");

        // 3: act
        mock.encode("a");

        // 4: verify
        verify(mock).encode(or(eq("a"), endsWith("b")));
    }
}
