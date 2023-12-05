package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.LoginPageForFrontEnd;
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

    @FindAll(@FindBy(xpath = "//h1[text()=\"Your order has been received.\"]"))
    List<WebElement> checkoutSuccessfulMsgList;
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
    WebElement guestAddInBill;

    @FindBy(id = "billing:city")
    WebElement guestCityInBill;
    @FindBy(id = "billing:postcode")
    WebElement guestZipInBill;
    @FindBy(id = "billing:country_id")
    WebElement guestCountryInBill;
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
    FunctionLibray functionLibray;
    Actions actions;
    Random random = new Random();


    public CheckOutOrder(WebDriver driver) {

        PageFactory.initElements(driver, this);
        loginForFrontEnd = new LoginPageForFrontEnd(driver);
        functionLibray = new FunctionLibray(driver);
        actions = new Actions(driver);
    }

    public void setLoginPageForFrontEnd() {


        loginForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());


    }

    public void addProductToCartAsGuest() {
        functionLibray.waitElemantPresent(lafayetteDressLink);
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
        functionLibray.waitElemantPresent(tabListInDashboard.get(0));
        tabListInDashboard.get(0).click();
        functionLibray.javaScripClick(productForAdding);
        // productForAdding.click();
        functionLibray.javaScriptScroll(addToCartButtonForRegistered);
        //addToCartButtonForRegistered.click();


    }

    public void proceedCheckOutProduct() {
        functionLibray.waitElemantPresent(countryDropdown);
        Select selectCountry = new Select(countryDropdown);
        functionLibray.sleep(5);
        selectCountry.selectByValue("TR");
        stateInput.sendKeys("Istanbul");
        zipInput.sendKeys("34570");
        proceedToCheckOutButton.click();


    }

    public void checkOutAsGuest() {


        functionLibray.waitElemantPresent(checkOutAsGuestCheckBox);
        checkOutAsGuestCheckBox.click();
        functionLibray.waitElemantPresent(continueButtonCheckOut);
        continueButtonCheckOut.click();

        functionLibray.waitElemantPresent(guestFirstNameInBill);
        guestFirstNameInBill.sendKeys(FunctionLibray.generateFakeName());
        functionLibray.waitElemantPresent(guestLastNameInBill);
        guestLastNameInBill.sendKeys(FunctionLibray.generateFakeName());
        functionLibray.waitElemantPresent(guestEmailInBill);
        guestEmailInBill.sendKeys("Guest" + functionLibray.timeStamp() + "@gmail.com");
        functionLibray.waitElemantPresent(guestAddInBill);
        guestAddInBill.sendKeys("silivri");

        functionLibray.waitElemantPresent(guestCountryInBill);
        Select select = new Select(guestCountryInBill);
        guestCountryInBill.click();
        select.selectByValue("TR");

        functionLibray.waitElemantPresent(guestCityInBill);
        guestCityInBill.sendKeys("Istanbul");
        functionLibray.waitElemantPresent(guestZipInBill);
        guestZipInBill.sendKeys("345000");

        functionLibray.waitElemantPresent(guestTelNoInBill);
        guestTelNoInBill.sendKeys("0090" + functionLibray.timeStamp());
        functionLibray.waitElemantPresent(shipToThisAdd);
        functionLibray.javaScripClick(shipToThisAdd);
        functionLibray.waitElemantPresent(continueButtonInBill);
        functionLibray.javaScripClick(continueButtonInBill);

        functionLibray.waitElemantPresent(shipMethodCheckbox1);
        shipMethodCheckbox1.click();
        functionLibray.waitElemantPresent(continueShipMethod);
        continueShipMethod.click();
        functionLibray.waitElemantPresent(cashOnDeliveryCheckbox);
        cashOnDeliveryCheckbox.click();
        functionLibray.waitElemantPresent(continueInPaymentMethod);
        continueInPaymentMethod.click();
        functionLibray.waitElemantPresent(placeOrderButton);
        placeOrderButton.click();

    }


    public void checkOutAsRegister() {
        functionLibray.waitElemantPresent(cartButton);
        functionLibray.javaScripClick(cartButton);
        functionLibray.waitElemantPresent(checkOutLink);

        checkOutLink.click();
        functionLibray.waitElemantPresent(shipToThisAdd1);
        functionLibray.javaScripClick(shipToThisAdd1);
        functionLibray.waitElemantPresent(continueButtonInBill);
        continueButtonInBill.click();
        functionLibray.waitElemantPresent(shipMethodCheckboxWithID);
        functionLibray.javaScripClick(shipMethodCheckboxWithID);
        functionLibray.javaScripClick(continueShipMethod);
        functionLibray.waitElemantPresent(cashOnDeliveryCheckbox);
        cashOnDeliveryCheckbox.click();
        functionLibray.waitElemantPresent(continueInPaymentMethod);
        continueInPaymentMethod.click();
        functionLibray.waitElemantPresent(placeOrderButton);
        placeOrderButton.click();

    }

    public boolean verifyCheckOut() {

        return checkoutSuccessfulMsgList.size() == 0;
    }

}
