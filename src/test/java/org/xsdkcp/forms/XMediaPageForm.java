package org.xsdkcp.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XMediaPageForm {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public XMediaPageForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определяю локаторы
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[3]/div[1]/div/div/div[@class=\"ant-space css-dev-only-do-not-override-7vi9ul ant-space-horizontal ant-space-align-center ant-space-gap-row-small ant-space-gap-col-small\"]/div[2]/button")
    private WebElement btnAddSource;

    //методы
    public void clickBtnAddSource() {
        btnAddSource.click();
    }

}
