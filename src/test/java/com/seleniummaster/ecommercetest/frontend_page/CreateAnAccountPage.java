package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {
    public WebDriver driver;
    FunctionLibrary functionLibrary;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    // create an account
    @FindBy(xpath = "//span[text()=\"My Account\"]")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@id='header']/div/div/div/a//span[@class='label']")
    WebElement accountLink;
    @FindBy(xpath = "//*[@id='header-account']/div/ul/li//a[@title='My Account']")
    WebElement myAccountLinkTab;
    @FindBy(xpath = "//*[@title='Create an Account']")
    WebElement createAnAccountLink;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='middlename']")
    WebElement middleNameField;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email_address']")
    WebElement emailAddressField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='confirmation']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@id='is_subscribed']")
    WebElement signUpForNewsletterBox;
    @FindBy(xpath = "//button[@title='Register']")
    WebElement registerLink;
    @FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
    WebElement successMassage;

    // please do not delete !

    public void createAnAccountMesut(String firstname, String middleName, String lastName,
                                     String emailAddress, String password, String confirmPassword){
        accountLink.click();
        myAccountLinkTab.click();
        createAnAccountLink.click();
        firstNameField.sendKeys(firstname);
        middleNameField.sendKeys(middleName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signUpForNewsletterBox.click();
        functionLibrary.waitElemantPresent(registerLink);
        registerLink.click();
    }
    public boolean verifyCreateAccount(){
        functionLibrary.waitElemantPresent(successMassage);
        if (successMassage.isDisplayed()){
            System.out.println("The new account successfully created !");
            return true;
        }else {
            System.out.println("The new account did not create !");
            return false;
        }
    }
}
