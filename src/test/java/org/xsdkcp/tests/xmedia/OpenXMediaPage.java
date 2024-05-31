package org.xsdkcp.tests.xmedia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xsdkcp.Utils;
import org.xsdkcp.forms.XMediaPageForm;
import org.xsdkcp.setup.ConfProperties;
import org.xsdkcp.setup.WebDriverSetup;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OpenXMediaPage {
    private WebDriver driver;
    private XMediaPageForm xMediaPageForm;

    @Before
    public void setup() {
        // Настройка драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = WebDriverSetup.getDriver();
        driver.get(ConfProperties.getProperty("web-guest-link"));
        xMediaPageForm = new XMediaPageForm(driver);
    }

    @Test
    public void openXMediaPageTest() {
        Utils.login(driver);

        // Ожидание перехода на главную страницу
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Максимальное время ожидания 10 секунд
        boolean isUrlChanged = wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("main_page_url")));

        // Проверка на успешный логин по URL
        String expectedUrlAfterLogin = ConfProperties.getProperty("main_page_url");
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL after login is not as expected.", expectedUrlAfterLogin, actualUrl);

        Utils.openXMediaPage(driver);

        // Ожидание перехода на страницу xMedia
        WebDriverWait waitXMedia = new WebDriverWait(driver, Duration.ofSeconds(10)); // Максимальное время ожидания 10 секунд
        boolean isUrlXMediaChanged = wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("xmedia_page_url")));

        // Проверка на успешный URL xMedia
        String expectedUrlXMedia = ConfProperties.getProperty("xmedia_page_url");
        String actualUrlXMedia = driver.getCurrentUrl();
        assertEquals("URL xMedia is not as expected.", expectedUrlXMedia, actualUrlXMedia);

        driver.quit();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}