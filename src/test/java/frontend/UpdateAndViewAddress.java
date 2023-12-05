package frontend;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateAndViewAddress {
    WebDriver driver;
    FunctionLibray functionLibray;
    @FindBy(xpath = "//div[@class=\"dashboard\"]/div[5]/div[2]/div[1]/div/div/a")
    WebElement editBillingAddressLink;
    @FindBy(id = "street_1")
    WebElement streetAddressField;
    @FindBy(id = "city")
    WebElement cityField;
    @FindBy(id = "zip")
    WebElement zipCodeField;
    @FindBy(id = "country")
    WebElement countrySelectField;
    @FindBy(xpath = "//*[text() = \"Save Address\"]")
    WebElement saveAddressButton;
    @FindBy(xpath = "//div[@class=\"col-1 addresses-primary\"]/ol/li[1]/address")
    WebElement changedBillingAddressText;
    @FindBy(xpath = "//div[@class=\"col-1 addresses-primary\"]/ol/li[2]/address")
    WebElement changedShippingAddressText;
    @FindBy(xpath = "//*[text()=\"The address has been saved.\"]")
    WebElement successMassageBillingAddress;
    @FindBy(xpath = "//*[text()=\"Change Shipping Address\"]")
    WebElement changeShippingAddressLink;
    @FindBy(xpath = "//*[text()=\"Change Billing Address\"]")
    WebElement changeBillingAddressLink;
    @FindBy(xpath = "//h1[text()=\"Address Book\"]")
    WebElement addressBookText;

    public UpdateAndViewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibray = new FunctionLibray(driver);
    }

    public boolean viewAddressBookMethod(){
        functionLibray.waitElemantPresent(addressBookText);
        if (addressBookText.isDisplayed()){
            System.out.println("Address book page opened and Address book seen");
            System.out.println(addressBookText.getText());
            return true;
        }else {
            System.out.println("View Address book is failed ");
            return false;
        }

    }

    public void editBillingAddressMethod(String street, String city, String zipCode) {
        functionLibray.waitElemantPresent(changeBillingAddressLink);
        changeBillingAddressLink.click();
        functionLibray.waitElemantPresent(streetAddressField);
        streetAddressField.clear();
        streetAddressField.sendKeys(street);
        functionLibray.waitElemantPresent(cityField);
        cityField.clear();
        cityField.sendKeys(city);
        functionLibray.waitElemantPresent(zipCodeField);
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
        functionLibray.waitElemantPresent(countrySelectField);
        Select selectCountry = new Select(countrySelectField);
        selectCountry.selectByValue("AU");
        functionLibray.waitElemantPresent(saveAddressButton);
        saveAddressButton.click();

    }

    public boolean verifyEditedBillingAddress() {
        functionLibray.waitElemantPresent(changedBillingAddressText);
        if (changedBillingAddressText.isDisplayed()) {
            System.out.println(String.format("Updated Billing Address : %s ", changedBillingAddressText.getText()));
            return true;
        } else {
            System.out.println("Update is failed");
            return false;
        }


    }

    public void editShippingAddressMethod(String street, String city, String zipCode) {
        functionLibray.waitElemantPresent(changeShippingAddressLink);
        changeShippingAddressLink.click();
        functionLibray.waitElemantPresent(streetAddressField);
        streetAddressField.clear();
        streetAddressField.sendKeys(street);
        functionLibray.waitElemantPresent(cityField);
        cityField.clear();
        cityField.sendKeys(city);
        functionLibray.waitElemantPresent(zipCodeField);
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
        functionLibray.waitElemantPresent(countrySelectField);
        Select selectCountry = new Select(countrySelectField);
        selectCountry.selectByValue("NL");
        functionLibray.waitElemantPresent(saveAddressButton);
        saveAddressButton.click();

    }

    public boolean verifyEditedShippingAddress() {
        functionLibray.waitElemantPresent(changedShippingAddressText);
        if (changeShippingAddressLink.isDisplayed()) {
            System.out.println(String.format("Updated shipping Address : %s ", changedShippingAddressText.getText()));
            return true;
        } else {
            System.out.println("Update is failed");
            return false;
        }

    }
}