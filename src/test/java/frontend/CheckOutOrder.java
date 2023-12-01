package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import com.github.javafaker.Faker;
import dashboard.LoginPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(xpath = "//button[@onclick=\"billing.save()\"]")
    WebElement continueButtonForBill;
    @FindBy(id = "shipping-address-select")
    WebElement shipAddDropdown;
    @FindBy(id = "shipping:same_as_billing")
    WebElement checkboxForShipAdd;
    @FindBy(xpath = "//button[@onclick=\"shipping.save()\"]")
    WebElement continueForShippingSave;
   @FindAll(@FindBy(xpath = "//input[@name=\"shipping_method\"]"))
           List<WebElement> shipMethodCheckbox;

   @FindBy(xpath = "//button[@onclick=\"shippingMethod.save()\"]")
           WebElement continueShipMethod;

   @FindAll(@FindBy(xpath = "//dt/input"))
           List<WebElement> paymentInfoCheckbox;

   @FindBy(xpath = "//button[@onclick=\"payment.save()\"]")
           WebElement continuePaymentMethod;
@FindBy(xpath = "//button[@onclick=\"review.save();\"]")
    WebElement  placeOrderButton;

@FindAll(@FindBy(xpath = "//h1[text()=\"Your order has been received.\"]"))
        List<WebElement> checkoutSuccessfulMsgList;
@FindBy(id = "login:guest")
        WebElement checkOutAsGuestCheckBox;
    @FindBy(id = "login:register")
    WebElement checkOutAsRegisteredCheckBox;

    @FindBy(id="onepage-guest-register-button")
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
    @FindBy(xpath = "//label[text()=\"Use Billing Address\"]")
            WebElement useBillAddCheckbox;

    @FindAll(@FindBy(xpath = "level0 has-children"))
          List<WebElement> tabListInDashboard;
    @FindBy(xpath = "//li[@class=\"level1 nav-1-1 first\"]")
            WebElement productForAdding;
    @FindBy(xpath = "//div[@class=\"actions\"]/button[@type='button' and @title='Add to Cart']")
            WebElement addToCartButtonForRegistered;

    LoginPageForFrontEnd loginForFrontEnd ;
    LoginDataForFrontEnd loginDataForFrontEnd = new LoginDataForFrontEnd();
    FunctionLibray functionLibray ;

    Random random = new Random();


    public CheckOutOrder(WebDriver driver) {
//this.driver= driver;
        PageFactory.initElements(driver, this);
        loginForFrontEnd= new LoginPageForFrontEnd(driver);
        functionLibray = new FunctionLibray(driver);
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
        tabListInDashboard.get(0).click();
        productForAdding.click();
        addToCartButtonForRegistered.click();



    }

    public void proceedCheckOutProduct() {
        functionLibray.waitElemantPresent(countryDropdown);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("TR");
        stateInput.sendKeys("Istanbul");
        zipInput.sendKeys("34570");
        proceedToCheckOutButton.click();


    }

    public void checkOutAsGuest(){

        functionLibray.waitElemantPresent(checkOutAsGuestCheckBox);
        checkOutAsGuestCheckBox.click();
        functionLibray.waitElemantPresent(continueButtonCheckOut);
        continueButtonCheckOut.click();
        functionLibray.waitElemantPresent(guestFirstNameInBill);
        guestFirstNameInBill.sendKeys(FunctionLibray.generateFakeName());
        functionLibray.waitElemantPresent(guestLastNameInBill);
        guestLastNameInBill.sendKeys(FunctionLibray.generateFakeName());
        functionLibray.waitElemantPresent(guestEmailInBill);
        guestEmailInBill.sendKeys("Guest"+functionLibray.timeStamp()+"@gmail.com");
        functionLibray.waitElemantPresent(guestAddInBill);
        guestAddInBill.sendKeys("silivri");
        functionLibray.waitElemantPresent(guestCityInBill);
        guestCityInBill.sendKeys("Istanbul");
        functionLibray.waitElemantPresent(guestZipInBill);
        guestZipInBill.sendKeys("345000");
        functionLibray.waitElemantPresent(guestCountryInBill);
        Select select = new Select(guestCountryInBill);
        guestCountryInBill.click();
        select.selectByValue("TR");
        functionLibray.waitElemantPresent(guestTelNoInBill);
        guestTelNoInBill.sendKeys("0090"+functionLibray.timeStamp());
        functionLibray.waitElemantPresent(listOfShippingAddType.get(0));
        listOfShippingAddType.get(0).click();
        functionLibray.waitElemantPresent(continueButtonForBill);
        continueButtonForBill.click();
//        functionLibray.waitElemantPresent(continueForShippingSave);
//        if (useBillAddCheckbox.isDisplayed()){
//            functionLibray.waitElemantPresent(useBillAddCheckbox);
//            useBillAddCheckbox.click();
//            functionLibray.waitElemantPresent(continueForShippingSave);
//            continueForShippingSave.click();
//        }
        functionLibray.sleep(60);
        functionLibray.waitElemantPresent(shipMethodCheckbox.get(0));
        shipMethodCheckbox.get(random.nextInt(shipMethodCheckbox.size())).click();
        functionLibray.waitElemantPresent(continueShipMethod);
        continueShipMethod.click();
        functionLibray.waitElemantPresent(paymentInfoCheckbox.get(2));
        paymentInfoCheckbox.get(2).click();
        functionLibray.waitElemantPresent(continuePaymentMethod);
        continuePaymentMethod.click();
        functionLibray.waitElemantPresent(placeOrderButton);
        placeOrderButton.click();

    }




    public void checkOut() {
        functionLibray.waitElemantPresent(listOfBillInfo.get(0));
        listOfBillInfo.get(random.nextInt(listOfBillInfo.size())).click();
        continueButtonForBill.click();
        if (shipAddDropdown.isDisplayed()) {
            checkboxForShipAdd.click();
            continueForShippingSave.click();

        }
        shipMethodCheckbox.get(random.nextInt(shipMethodCheckbox.size())).click();
       continueShipMethod.click();
       paymentInfoCheckbox.get(2).click();
       continuePaymentMethod.click();
       placeOrderButton.click();

    }

    public boolean verifyCheckOut(){
        Boolean checkOutStatus = false;
        if (checkoutSuccessfulMsgList.size()>0)
            checkOutStatus=true;

      return checkOutStatus;
    }

}
