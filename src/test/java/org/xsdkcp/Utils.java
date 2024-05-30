package org.xsdkcp;

import org.openqa.selenium.WebDriver;
import org.xsdkcp.forms.AuthForm;
import org.xsdkcp.forms.MainPageForm;
import org.xsdkcp.setup.ConfProperties;

public class Utils {

    public static void login(WebDriver driver) {
        AuthForm authForm = new AuthForm(driver);
        authForm.fillUserField(ConfProperties.getProperty("username"));
        authForm.fillPasswordField(ConfProperties.getProperty("password"));
        authForm.fillSignalingField(ConfProperties.getProperty("signaling_url"));
        authForm.clickBtnSubmit();
    }

    public static void logout(WebDriver driver) {
        MainPageForm mainPageForm = new MainPageForm(driver);
        mainPageForm.clickBtnLogout();
    }

    public static void openXMediaPage(WebDriver driver) {
        MainPageForm mainPageForm = new MainPageForm(driver);
        mainPageForm.clickBtnXMedia();
    }
}
