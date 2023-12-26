package com.seleniummaster.ecommercetest.backend_page.customersmodule;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
    WebDriver driver;

    FunctionLibrary functionLibrary;

    Actions actions;

    @FindBy(xpath = "//ul[@id='nav']//li[4]/a/span[text()='Customers']")
    WebElement customerTab;

    @FindBy(xpath = "//ul[@id='nav']/li[4]/ul/li/a/span[text()='Manage Customers']")
    WebElement manageCustomerLink;

    @FindBy(xpath = "(//*[text()=\"Add New Customer\"])[1]")
    WebElement addNewCustomerLink;

    @FindBy(xpath = "//*[@id=\"_accountwebsite_id\"]")
    WebElement associateToWebsiteLink;
    @FindBy(xpath = "//*[@id=\"_accountwebsite_id\"]/option[5]")
    WebElement associateOptionLink;

    @FindBy(xpath = "//*[@name=\"account[group_id]\"]")
    WebElement groupLink;

    @FindBy(xpath = "//*[@name=\"account[group_id]\"]/option[12]")
    WebElement groupOptionLink;

    @FindBy(xpath = "//input[@id=\"_accountfirstname\"]")
    WebElement firstNameField;

    @FindBy(xpath = "(//input[@id=\"_accountlastname\"])[1]")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id=\"_accountemail\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id=\"_accountpassword\"]")
    WebElement passwordField;

    @FindBy(xpath = "(//*[@title='Save Customer'])[1]")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//*[@id=\"messages\"]/ul")
    WebElement addedNewCustomerSuccessMessage;

    @FindBy(xpath = "(//a[@class='link-logout'])[1]")
    WebElement logoutLink;

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
        actions=new Actions(driver);
    }


    public void addNewCustomer(String customerEmail) {
        functionLibrary.waitElemantPresent(customerTab);
        actions.moveToElement(customerTab).build().perform();
        functionLibrary.waitElemantPresent(manageCustomerLink);
        manageCustomerLink.click();
        functionLibrary.waitElemantPresent(addNewCustomerLink);
        addNewCustomerLink.click();
        Select select1=new Select(associateToWebsiteLink);
        select1.selectByVisibleText("e-commerce Application");
        Select select2=new Select(groupLink);
        select2.selectByVisibleText("LondonTeam ");
        functionLibrary.waitElemantPresent(firstNameField);
        firstNameField.sendKeys(functionLibrary.generateFakeName1());
        functionLibrary.waitElemantPresent(lastNameField);
        lastNameField.sendKeys(functionLibrary.generateFakeName1()+"Team3");
        functionLibrary.waitElemantPresent(emailField);
        emailField.sendKeys(customerEmail);
        functionLibrary.waitElemantPresent(passwordField);
        passwordField.sendKeys("A123456");
        functionLibrary.waitElemantPresent(saveCustomerButton);
        saveCustomerButton.click();
    }

    public boolean verifyForAddingNewCustomer() {
        functionLibrary.waitElemantPresent(addedNewCustomerSuccessMessage);
        if
        (addedNewCustomerSuccessMessage.isDisplayed()) {
            System.out.println("The customer has been saved. ");
            return true;
        } else {
            System.out.println("The customer has been not saved.");
            System.out.println("Customer with the same email already exists.");
            return false;
        }


    }public void logOut(){
        functionLibrary.waitElemantPresent(logoutLink);
        logoutLink.click();
    }
}
