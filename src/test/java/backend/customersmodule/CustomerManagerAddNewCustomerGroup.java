package backend.customersmodule;

import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForBackEnd;
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
//    @FindBy(xpath = "\n" +"//span[text()= \"Customer Groups\"]")
//    WebElement customerGroupLink;
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
//        functionLibray.waitElemantPresent(customerTab);
//        customerTab.click();
//        functionLibray.waitElemantPresent(customerGroupLink);
//        customerGroupLink.click();
        functionLibray.waitElemantPresent(addNewCustomerGroupButton);
        addNewCustomerGroupButton.click();
        String groupName = "sdeat"+functionLibray.timeStamp();
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
