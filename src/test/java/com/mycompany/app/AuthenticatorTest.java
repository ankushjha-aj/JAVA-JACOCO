package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorTest {
    private final Authenticator authenticator = new Authenticator();

    @Test
    public void testAuthenticateWithValidCredentials() {
        assertTrue(authenticator.authenticate("Ankush", "Ankush@123"));
    }

    @Test
    public void testAuthenticateWithInvalidUsername() {
        assertFalse(authenticator.authenticate("wrong", "Ankush@123"));
    }

    @Test
    public void testAuthenticateWithInvalidPassword() {
        assertFalse(authenticator.authenticate("Ankush", "wrong"));
    }

    @Test
    public void testAuthenticateWithInvalidCredentials() {
        assertFalse(authenticator.authenticate("wrong", "wrong"));
    }
} 