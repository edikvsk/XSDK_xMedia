package org.xsdkcp.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthForm {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public AuthForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определяю локаторы
    @FindBy(id = "username")
    private WebElement fieldUser;

    @FindBy(id = "password")
    private WebElement fieldPassword;

    @FindBy(id = "signaling_url")
    private WebElement fieldSignaling;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    //методы
    public void fillUserField(String username) {
        fieldUser.sendKeys(username);
    }

    public void fillPasswordField(String password) {
        fieldPassword.sendKeys(password);
    }

    public void fillSignalingField(String signalingUrl) {
        fieldSignaling.sendKeys(signalingUrl);
    }

    public void clickBtnSubmit() {
        btnSubmit.click();
    }
}
