package com.mghita.presentation.unit.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.isMock;

@ExtendWith(MockitoExtension.class)
public class CAnnotationsTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

/*    @BeforeEach
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void test() {
        passwordEncoder.encode("1");
        verify(passwordEncoder, times(1)).encode(anyString());
        verifyNoMoreInteractions(userRepository);
        assertFalse(isMock(userService));
    }
}
