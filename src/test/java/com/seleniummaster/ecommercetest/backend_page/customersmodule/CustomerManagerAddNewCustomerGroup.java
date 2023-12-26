package com.seleniummaster.ecommercetest.backend_page.customersmodule;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagerAddNewCustomerGroup {
    public WebDriver driver;
    FunctionLibrary functionLibray;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    @FindBy(xpath = " //input[@id=\"username\"]")
    WebElement userNameField;
    @FindBy(xpath = "//input[@name=\"login[password]\"]")
    WebElement password;
    @FindBy(xpath = "\n" +" //input[@value=\"Login\"]")
    WebElement loginButton;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Customers\"]")
    WebElement customerTab;
    @FindBy(xpath = "//button[@title=\"Add New Customer Group\"]")
    WebElement addNewCustomerGroupButton;
    @FindBy(xpath = "//tr//input[@id=\"customer_group_code\"]")
    WebElement groupNameField;
    @FindBy(xpath = "//span[text()=\"Save Customer Group\"]")
    WebElement saveCustomerGroupButton;
    @FindBy(xpath = " //span[text()=\"The customer group has been saved.\"]")
    WebElement successMessage;

    public CustomerManagerAddNewCustomerGroup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray=new FunctionLibrary(driver);

    }

    public void addNewCustomerGroup(){
        functionLibray.waitElemantPresent(addNewCustomerGroupButton);
        addNewCustomerGroupButton.click();
        String groupName = "SDT2023Magento-Team3"+functionLibray.timeStamp();
        functionLibray.waitElemantPresent(groupNameField);
        groupNameField.sendKeys(groupName);
        functionLibray.waitElemantPresent(saveCustomerGroupButton);
        saveCustomerGroupButton.click();
    }
    public boolean verifyAddedNewCustomerGroup(){
        functionLibray.waitElemantPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Customer group successfully added");
        }
        return true;
    }

}
