package org.xsdkcp;

import org.openqa.selenium.WebDriver;
import org.xsdkcp.forms.AuthForm;
import org.xsdkcp.setup.ConfProperties;

public class Utils {

    public static void login(WebDriver driver) {
        AuthForm authForm = new AuthForm(driver);
        authForm.fillUserField(ConfProperties.getProperty("username"));
        authForm.fillPasswordField(ConfProperties.getProperty("password"));
        authForm.fillSignalingField(ConfProperties.getProperty("signaling_url"));
        authForm.clickBtnSubmit();
    }
}
