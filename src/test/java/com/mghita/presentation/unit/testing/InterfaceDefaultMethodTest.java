package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InterfaceDefaultMethodTest {

    @Test
    public void mockedDefaultMethod() {
        AnInterface mock = mock(AnInterface.class);
        assertFalse(mock.isTrue());
    }

    @Test
    public void callRealDefaultMethod() {
        AnInterface mock = mock(AnInterface.class);
        when(mock.isTrue()).thenCallRealMethod();
        assertTrue(mock.isTrue());
    }

    interface AnInterface {
        default boolean isTrue() {
            return true;
        }
    }
}
