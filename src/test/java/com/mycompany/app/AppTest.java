package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Basic test for App class instantiation.
 * Note: GUI logic (login, logout, etc.) is not covered by these tests.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage());
    }
}
