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

public class AddDestination {
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
    public void addSourceTest() {
        Utils.login(driver);

        // Ожидание перехода на главную страницу
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Максимальное время ожидания 10 секунд
        boolean isUrlChanged = wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("main_page_url")));

        Utils.openXMediaPage(driver);

        // Ожидание перехода на страницу xMedia
        WebDriverWait waitXMedia = new WebDriverWait(driver, Duration.ofSeconds(10)); // Максимальное время ожидания 10 секунд
        boolean isUrlXMediaChanged = waitXMedia.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("xmedia_page_url")));

        xMediaPageForm.clickBtnAddDestination();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}