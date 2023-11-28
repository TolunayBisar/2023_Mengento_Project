package dashboard;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:43
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginPageForBackEnd {
    public WebDriver driver;
    FunctionLibray functionLibrary;
   @FindBy(linkText = "Log in to Admin Panel")
   WebElement panelText;
    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "login")
    WebElement userPasswordField;
    @FindBy(xpath = "//input[@value=\"Login\"]")
    WebElement loginButton;


    public LoginPageForBackEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);
    }

    public boolean verifyBackEndOpen() {
        functionLibrary.waitElemantPresent(panelText);
        if (panelText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }




    public void enterUserName(String userName) {
        functionLibrary.waitElemantPresent(userNameField);
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        functionLibrary.waitElemantPresent(userPasswordField);
        userPasswordField.sendKeys(password);

    }

    public void clickLoginButton() {
        functionLibrary.waitElemantPresent(loginButton);
        loginButton.click();
    }

    public void logIn(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }
}
