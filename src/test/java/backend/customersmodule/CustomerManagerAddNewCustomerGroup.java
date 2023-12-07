package backend.customersmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerManagerAddNewCustomerGroup {
    public WebDriver driver;
    FunctionLibray functionLibray;
    @FindBy(xpath = " //input[@id=\"username\"]")
    WebElement userNameField;
    @FindBy(xpath = "//input[@name=\"login[password]\"]")
    WebElement password;
    @FindBy(xpath = "\n" +" //input[@value=\"Login\"]")
    WebElement loginButton;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Customers\"]")
    WebElement customerTab;
    @FindBy(xpath = "\n" +"//span[text()= \"Customer Groups\"]")
    WebElement customerGroupLink;
    @FindBy(xpath = "//button[@title=\"Add New Customer Group\"]")
    WebElement addNewCustomerGroupButton;
    @FindBy(xpath = "//tr//input[@id=\"customer_group_code\"]")
    WebElement groupNameField;
    @FindBy(xpath = "//span[text()=\"Save Customer Group\"]")
    WebElement saveCustomerGroupButton;
    @FindBy(xpath = " //span[text()=\"The customer group has been saved.\"]")
    WebElement successMessage;



}
