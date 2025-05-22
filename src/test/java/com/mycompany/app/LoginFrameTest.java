package com.mycompany.app;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;
import org.assertj.swing.edt.GuiActionRunner;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import java.awt.GraphicsEnvironment;

public class LoginFrameTest {
    private FrameFixture window;

    @BeforeAll
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @BeforeEach
    public void setUp() {
        assumeFalse(GraphicsEnvironment.isHeadless());
        window = new FrameFixture(GuiActionRunner.execute(LoginFrame::new));
        window.show();
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void shouldShowErrorOnInvalidLogin() {
        window.textBox("usernameField").enterText("wrong");
        window.textBox("passwordField").enterText("wrong");
        window.button("loginButton").click();
        window.optionPane().requireErrorMessage();
    }

    @Test
    public void shouldShowSuccessOnValidLogin() {
        window.textBox("usernameField").enterText("Ankush");
        window.textBox("passwordField").enterText("Ankush@123");
        window.button("loginButton").click();
        window.optionPane().requireInformationMessage();
    }
} 