package org.xsdkcp.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xsdkcp.Utils;
import org.xsdkcp.forms.AuthForm;
import org.xsdkcp.setup.ConfProperties;
import org.xsdkcp.setup.WebDriverSetup;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Login {
    public static AuthForm authForm;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        // Настройка драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = WebDriverSetup.getDriver();
        driver.get(ConfProperties.getProperty("web-guest-link"));
        authForm = new AuthForm(driver);
    }

    @Test
    public void loginTest() {

        Utils.login(driver);

        // Ожидание перехода на главную страницу
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Максимальное время ожидания 10 секунд
        boolean isUrlChanged = wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("main_page_url")));

        // Проверка на успешный логин по URL
        String expectedUrlAfterLogin = ConfProperties.getProperty("main_page_url");
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL after login is not as expected.", expectedUrlAfterLogin, actualUrl);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}