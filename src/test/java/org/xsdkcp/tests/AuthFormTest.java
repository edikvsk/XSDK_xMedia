package org.xsdkcp.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xsdkcp.forms.AuthForm;
import org.xsdkcp.setup.WebDriverSetup;

public class AuthFormTest {
    public static AuthForm authForm;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = WebDriverSetup.getDriver();
        authForm = new AuthForm(driver);
    }

    @Test
    public void loginTest() {
        authForm.fillUserField();
        authForm.fillPasswordField();
        authForm.fillSignalingField();
        authForm.clickBtnSubmit();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.quitDriver();
    }
}