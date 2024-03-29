package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class KDeepStubsTest {

    @Test
    public void testVerify() {
        We mock = mock(We.class, Mockito.RETURNS_DEEP_STUBS); //an answer that returns deep stubs (not mocks).

        mock.we().are().so().deep();

        verify(mock.we().are().so()).deep();
    }

    @Test
    public void testAssert() {
        We mock = mock(We.class, Mockito.RETURNS_DEEP_STUBS);

        when(mock.we().are().so().deep()).thenReturn(true);

        assertTrue(mock.we().are().so().deep());
    }

    interface We { Are we(); }
    interface Are { So are(); }
    interface So { Deep so(); }
    interface Deep { boolean deep(); }
}
