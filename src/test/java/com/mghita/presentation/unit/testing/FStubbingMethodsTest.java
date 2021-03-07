package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FStubbingMethodsTest {

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void beforeMethod() {
        passwordEncoder = mock(PasswordEncoder.class);
    }

    @Test
    public void thenReturn() {
        when(passwordEncoder.encode("1")).thenReturn("a");

        assertEquals("a", passwordEncoder.encode("1"));
    }

    @Test
    public void thenReturnConsecutive() {
        when(passwordEncoder.encode("1")).thenReturn("a", "b");

        assertEquals("a", passwordEncoder.encode("1"));
        assertEquals("b", passwordEncoder.encode("1"));
        assertEquals("b", passwordEncoder.encode("1"));
    }

    @Test
    public void thenAnswerGetArgument() {
        when(passwordEncoder.encode("1")).thenAnswer(invocation -> invocation.getArgument(0) + "!");

        assertEquals("1!", passwordEncoder.encode("1"));
    }

    @Test
    public void thenAnswerThrowException() {
        when(passwordEncoder.encode("1")).thenAnswer(invocation -> {
            throw new IllegalArgumentException();
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordEncoder.encode("1"));
    }

    @Test
    public void thenThrowExceptionByInstance() {
        when(passwordEncoder.encode("1")).thenThrow(new IllegalArgumentException());
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordEncoder.encode("1"));
    }

    @Test
    public void thenThrowExceptionByClass() {
        when(passwordEncoder.encode("1")).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordEncoder.encode("1"));
    }

    @Test
    public void thenAnswerCallRealMethod() {
        Date mock = mock(Date.class);
        doAnswer(InvocationOnMock::callRealMethod).when(mock).setTime(42);

//        doCallRealMethod().when(mock).setTime(42);
        when(mock.getTime()).thenCallRealMethod();

        mock.setTime(42);

        assertEquals(42, mock.getTime());
    }

    @Test
    public void thenCallRealMethodFail() {
        Assertions.assertThrows(Exception.class, () -> when(passwordEncoder.encode("1")).thenCallRealMethod()); // calling real abstract method
    }
}
