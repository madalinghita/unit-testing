package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.SmartNullPointerException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LMockSettingsTest {

    @Test
    public void returnsSmartNulls() {
        UserRepository userRepository = mock(UserRepository.class, RETURNS_SMART_NULLS);
        User user = userRepository.findById(null);

        // user is SmartNull but would be null with RETURNS_DEFAULTS answer
        assertNotNull(user);

        // will fail with SmartNullPointerException and nice stacktrace
        Assertions.assertThrows(SmartNullPointerException.class, () -> {
            String passwordHash = user.getPasswordHash();
        });
    }

    @Test
    public void returnsMocks() {
        UserRepository userRepository = mock(UserRepository.class, RETURNS_MOCKS);
        User user = userRepository.findById(null);

        // mocked method returned a mock
        assertNotNull(user);
        assertEquals("", user.getPasswordHash());
        assertFalse(user.isEnabled());
    }

    @Test
    public void extraInterfaces() {
        PasswordEncoder mock = mock(
                PasswordEncoder.class, withSettings().extraInterfaces(List.class, Map.class));

        assertTrue(mock instanceof List);
        assertTrue(mock instanceof Map);
    }
}
