package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.github.javafaker.Faker;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * @author : tolunaybisar
 * @created : 30.11.2023,16:43
 * @Email :tolunay.bisar@gmail.com
 **/
public class CheckOutOrder extends BaseClass {
    //WebDriver driver;

    @FindBy(xpath = "//a[text()=\"Lafayette Convertible Dress\"]")
    WebElement lafayetteDressLink;

    @FindBy(css = "select#attribute92")
    WebElement colorDropDown;
    @FindBy(xpath = "//select[@id=\"attribute180\"]")
    WebElement sizeDropDown;
    @FindBy(id = "qty")
    WebElement quantityInput;
    @FindBy(css = "div.add-to-cart-buttons button")
    WebElement addToCartButton;
    @FindBy(xpath = "//select[@id=\"country\"]")
    WebElement countryDropdown;

    @FindAll(@FindBy(xpath = "//select[@id=\"country\"]/option"))
    List<WebElement> countriesList;

    @FindBy(id = "region")
    WebElement stateInput;
    @FindBy(id = "region_id")
    WebElement stateSelectDropdown;
    @FindAll(@FindBy(xpath = "//select[@id=\"region_id\"]/option"))
    List<WebElement> statesListInBill;
    @FindBy(id = "postcode")
    WebElement zipInput;
    @FindBy(xpath = "//span[text()=\"Proceed to Checkout\"]")
    WebElement proceedToCheckOutButton;

    @FindAll(@FindBy(xpath = "//input[@type=\"radio\"]"))
    List<WebElement> listOfBillInfo;

    @FindBy(id = "billing:use_for_shipping_yes")
    WebElement shipToThisAdd;

    @FindBy(xpath = "//button[@onclick=\"billing.save()\"]")
    WebElement continueButtonForBill;
    @FindBy(xpath = "//div[@id=\"billing-buttons-container\"]//button")
    WebElement continueButtonInBill;
    ;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement gulbaharContinue;
    @FindBy(id = "shipping-address-select")
    WebElement shipAddDropdown;
    @FindBy(id = "shipping:same_as_billing")
    WebElement checkboxForShipAdd;
    @FindBy(xpath = "//button[@onclick=\"shipping.save()\"]")
    WebElement continueForShippingSave;
    @FindAll(@FindBy(xpath = "//input[@name=\"shipping_method\"]"))
    List<WebElement> shipMethodCheckbox;

    @FindBy(xpath = "//input[@id=\"s_method_freeshipping_freeshipping\"]")
    WebElement shipMethodCheckbox1;

    @FindBy(id = "s_method_freeshipping_freeshipping")
    WebElement shipMethodCheckboxWithID;
    @FindBy(xpath = "//button[@onclick=\"shippingMethod.save()\"]")
    WebElement continueShipMethod;

    @FindAll(@FindBy(xpath = "//dt/input"))
    List<WebElement> paymentInfoCheckbox;
    @FindBy(id = "p_method_cashondelivery")
    WebElement cashOnDeliveryCheckbox;

    @FindBy(xpath = "//button[@onclick=\"payment.save()\"]")
    WebElement continueInPaymentMethod;
    @FindBy(xpath = "//button[@onclick=\"review.save();\"]")
    WebElement placeOrderButton;

    @FindBy(xpath = "//h1[text()=\"Your order has been received.\"]")
    WebElement checkoutSuccessfulMsgList;
    @FindBy(id = "login:guest")
    WebElement checkOutAsGuestCheckBox;
    @FindBy(id = "login:register")
    WebElement checkOutAsRegisteredCheckBox;

    @FindBy(id = "onepage-guest-register-button")
    WebElement continueButtonCheckOut;
    @FindBy(id = "billing:firstname")
    WebElement guestFirstNameInBill;

    @FindBy(id = "billing:lastname")
    WebElement guestLastNameInBill;
    @FindBy(id = "billing:email")
    WebElement guestEmailInBill;
    @FindBy(id = "billing:street1")
    WebElement guestAddressInBill;

    @FindBy(id = "billing:city")
    WebElement guestCityInBill;
    @FindBy(id = "billing:postcode")
    WebElement guestZipInBill;
    @FindBy(id = "billing:country_id")
    WebElement guestCountryInBill;

    @FindAll(@FindBy(xpath = "//select[@id=\"billing:country_id\"]/option"))
    List<WebElement> guestCountryInBillList;
    @FindBy(id = "billing:region")
    WebElement guestStateInputInBill;

    @FindBy(id = "billing:region_id")
    WebElement guestStateDropdown;

    @FindAll(@FindBy(xpath = "//select[@id=\"billing:region_id\"]/option"))
    List<WebElement> guestStateList;

    @FindBy(id = "billing:telephone")
    WebElement guestTelNoInBill;
    @FindBy(id = "billing:use_for_shipping_yes")
    WebElement checkboxShipToThisAdd;

    @FindBy(id = "billing:use_for_shipping_no")
    WebElement checkboxShipToDiffAdd;
    @FindAll(@FindBy(xpath = "//input[@name=\"billing[use_for_shipping]\"]"))
    List<WebElement> listOfShippingAddType;
    @FindBy(id = "billing:use_for_shipping_yes")
    WebElement shipToThisAdd1;
    @FindBy(xpath = "//label[text()=\"Use Billing Address\"]")
    WebElement useBillAddCheckbox;

    @FindAll(@FindBy(xpath = "//a[@class=\"level0 has-children\"]"))
    List<WebElement> tabListInDashboard;
    @FindBy(xpath = "//li[@class=\"level1 nav-1-1 first\"]/a")
    WebElement productForAdding;
    @FindBy(xpath = "//div[@class=\"actions\"]/button[@type='button' and @title='Add to Cart']")
    WebElement addToCartButtonForRegistered;
    @FindBy(xpath = "//span[contains(text(),\"Cart\")][1]")
    WebElement cartButton;

    @FindBy(xpath = "//a[contains(text(),\"Checkout\")][1]")
    WebElement checkOutLink;

    LoginPageForFrontEnd loginForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd = new LoginDataForFrontEnd();
    FunctionLibrary functionLibray;
    Actions actions;
    Random random = new Random();


    public CheckOutOrder(WebDriver driver) {

        PageFactory.initElements(driver, this);
        loginForFrontEnd = new LoginPageForFrontEnd(driver);
        functionLibray = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }


    public void addProductToCartAsGuest() {
        functionLibray.waitForPresent(lafayetteDressLink);
        lafayetteDressLink.click();
        Select selectColor = new Select(colorDropDown);
        selectColor.selectByValue("27");
        Select selectSize = new Select(sizeDropDown);
        selectSize.selectByIndex(2);
        quantityInput.clear();
        quantityInput.sendKeys("1");
        addToCartButton.click();

    }


    public void addProductAsRegisteredToCart() {
        functionLibray.waitForPresent(tabListInDashboard.get(0));
        tabListInDashboard.get(0).click();
        functionLibray.javaScripClick(productForAdding);
        functionLibray.javaScriptScroll(addToCartButtonForRegistered);


    }

    public void proceedCheckOutProduct() {
        functionLibray.waitForPresent(countryDropdown);
        Select selectCountry = new Select(countryDropdown);
        functionLibray.sleep(5);

        selectCountry.selectByIndex(random.nextInt(countriesList.size()));
        Select selectState = new Select(stateSelectDropdown);
        if (stateInput.isDisplayed()) {
            stateInput.sendKeys(Faker.instance().address().cityName());
        } else if (stateSelectDropdown.isDisplayed()) {
            selectState.selectByIndex(random.nextInt(statesListInBill.size()));

        }
        zipInput.sendKeys(random.nextInt() + "");
        proceedToCheckOutButton.click();


    }

    public void checkOutAsGuest() {


        functionLibray.waitForPresent(checkOutAsGuestCheckBox);
        checkOutAsGuestCheckBox.click();
        functionLibray.waitForPresent(continueButtonCheckOut);
        continueButtonCheckOut.click();
    }

    public void fillBillInfo() {

        functionLibray.waitForPresent(guestFirstNameInBill);
        guestFirstNameInBill.sendKeys(FunctionLibrary.generateFakeName());
        functionLibray.waitForPresent(guestLastNameInBill);
        guestLastNameInBill.sendKeys(FunctionLibrary.generateFakeName());
        functionLibray.waitForPresent(guestEmailInBill);
        guestEmailInBill.sendKeys("Guest" + functionLibray.timeStamp() + "@gmail.com");
        functionLibray.waitForPresent(guestAddressInBill);
        guestAddressInBill.sendKeys(Faker.instance().address().fullAddress());

        functionLibray.waitForPresent(guestCountryInBill);
        Select select = new Select(guestCountryInBill);
        guestCountryInBill.click();
        select.selectByIndex(random.nextInt(guestCountryInBillList.size()));
        Select select1 = new Select(guestStateDropdown);
        if (guestStateInputInBill.isDisplayed()) {
            guestStateInputInBill.sendKeys(Faker.instance().address().cityName());
        } else if (guestStateDropdown.isDisplayed()) {
            select1.selectByIndex(random.nextInt(guestStateList.size()));

        }

        functionLibray.waitForPresent(guestCityInBill);
        guestCityInBill.sendKeys(Faker.instance().address().cityName());
        functionLibray.waitForPresent(guestZipInBill);
        guestZipInBill.sendKeys(random.nextInt(100000) + "");

        functionLibray.waitForPresent(guestTelNoInBill);
        guestTelNoInBill.sendKeys(Faker.instance().phoneNumber() + functionLibray.timeStamp());
        functionLibray.waitForPresent(shipToThisAdd);
        functionLibray.javaScripClick(shipToThisAdd);
        functionLibray.waitForPresent(continueButtonInBill);
        functionLibray.javaScripClick(continueButtonInBill);
    }

    public void continueCheckoutAsGuest() {

        functionLibray.waitForPresent(shipMethodCheckbox1);
        shipMethodCheckbox1.click();
        functionLibray.waitForPresent(continueShipMethod);
        continueShipMethod.click();
        functionLibray.waitForPresent(cashOnDeliveryCheckbox);
        cashOnDeliveryCheckbox.click();
        functionLibray.waitForPresent(continueInPaymentMethod);
        continueInPaymentMethod.click();
        functionLibray.waitForPresent(placeOrderButton);
        placeOrderButton.click();

    }


    public void checkOutAsRegister() {
        functionLibray.waitForPresent(cartButton);
        functionLibray.javaScripClick(cartButton);
        functionLibray.waitForPresent(checkOutLink);
        checkOutLink.click();
        functionLibray.waitForPresent(shipToThisAdd1);
        functionLibray.javaScripClick(shipToThisAdd1);
        functionLibray.waitForPresent(continueButtonInBill);
        continueButtonInBill.click();

        functionLibray.waitForPresent(shipMethodCheckboxWithID);
        functionLibray.javaScripClick(shipMethodCheckboxWithID);
        functionLibray.javaScripClick(continueShipMethod);
        functionLibray.waitForPresent(cashOnDeliveryCheckbox);
        cashOnDeliveryCheckbox.click();
        functionLibray.waitForPresent(continueInPaymentMethod);
        continueInPaymentMethod.click();
        functionLibray.waitForPresent(placeOrderButton);
        placeOrderButton.click();

    }

    public boolean verifyCheckOut() {
        functionLibray.waitForPresent(checkoutSuccessfulMsgList);

        if (checkoutSuccessfulMsgList.isDisplayed()) {
            System.out.println("Checkout Successful");
            return true;
        } else return false;
    }

}
