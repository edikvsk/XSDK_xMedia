package org.xsdkcp.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageForm {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public MainPageForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определяю локаторы
    @FindBy(xpath = "//li[./span/div[text()='xGraph']]")
    private WebElement btnXGraph;

    @FindBy(xpath = "//li[./span/div[text()='xMedia']]")
    private WebElement btnXMedia;

    @FindBy(xpath = "//li[./span/div[text()='Licenses']]")
    private WebElement btnLicenses;

    @FindBy(xpath = "//li[./span/div[text()='Requests']]")
    private WebElement btnRequests;

    @FindBy(xpath = "//li[./span/div[text()='Logout']]")
    private WebElement btnLogout;

    //методы
    public void clickBtnLogout() {
        btnLogout.click();
    }

    public void clickBtnXMedia() {
        btnXMedia.click();
    }


}
