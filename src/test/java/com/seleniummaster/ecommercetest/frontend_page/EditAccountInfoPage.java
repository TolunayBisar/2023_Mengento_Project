package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInfoPage {
    WebDriver driver;
    FunctionLibrary functionLibray;

    public EditAccountInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibrary(driver);
    }
    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id="middlename")
    WebElement middleName;
    @FindBy(id = "lastname")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;
    @FindBy(id = "current_password")
    WebElement currentPassword;
    @FindBy(xpath = "//p[@class='back-link']/following-sibling::button[@type='submit']")
    WebElement saveButton;
    @FindBy(xpath = "//li[@class='success-msg']")
    WebElement successMessage;
    public void editAccountInfo(String FirstName,String MiddleName,String LastName,String Email,String Password){
        functionLibray.waitElemantPresent(firstName);
        firstName.clear();
        firstName.sendKeys(FirstName);
        functionLibray.waitElemantPresent(middleName);
        middleName.clear();
        middleName.sendKeys(MiddleName);
        functionLibray.waitElemantPresent(lastName);
        lastName.clear();
        lastName.sendKeys(LastName);
        functionLibray.waitElemantPresent(emailAddress);
        emailAddress.clear();
        emailAddress.sendKeys(Email);
        functionLibray.waitElemantPresent(currentPassword);
        currentPassword.sendKeys(ApplicationConfig.readFromConfig("config.properties","password_edit"));
        functionLibray.waitElemantPresent(saveButton);
        saveButton.click();

    }
    public boolean verifyEditSuccessfully(){
        if (successMessage.isDisplayed()){
            System.out.println("Information succesully edit");
            return true;
        }else {
            System.out.println("Information edit failed");
            return false;
        }

    }


}
