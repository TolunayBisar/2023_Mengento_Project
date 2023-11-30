package dashboard;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:00
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginPageForFrontEnd {

    WebDriver driver;
    FunctionLibray functionLibrary;


    @FindBy(linkText = "Welcome ")
    WebElement welcomeText;
    @FindBy(xpath = "//div[@class=\"block-title\"]/following-sibling::ul//a[@title=\"My Account\"]")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[3]/div/div[5]/ul/li[1]/a")
    WebElement getMyAccountLink;
    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(id = "send2")
    WebElement loginButton;




    public LoginPageForFrontEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);

    }

    public boolean verifyMengentoFrontEndOpen() {
        functionLibrary.waitElemantPresent(welcomeText);
        if (welcomeText.isDisplayed()) {
            System.out.println("Megento FrontEnd succesfully opened");
        }
        return true;
    }



    // write login action
    public void enterUserName(String emailAdd) {
        //functionLibrary.waitElemantPresent(emailField);
       emailField.sendKeys(emailAdd);
    }

    public void enterPassword(String password) {
        functionLibrary.waitElemantPresent(passwordField);
        passwordField.sendKeys(password);

    }

    public void clickLoginButton() {
        functionLibrary.waitElemantPresent(loginButton);
        loginButton.click();
    }

    public void logIn(String userName, String password) {
//        actions =  new Actions(driver);
//        actions.moveToElement(myAccountLink).click().build().perform();
//       functionLibrary.waitElemantPresent(myAccountLink);
 myAccountLink.click();
//         driver.findElement(By.xpath("//a/span[text()=\"Account\"]")).click();
       // driver.findElement(By.xpath("//div[@class=\"c\"]//li/a[text()=\"My Account\"]")).click();
//getMyAccountLink.click();
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }
}
