package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
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
    @FindBy(id = "country")
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
    @FindBy(linkText = "Use Billing Address")
    WebElement checkboxForShipAdd;
    @FindBy(xpath = "//button[@onclick=\"shipping.save()\"]")
    WebElement continueForShippingSave;
   @FindAll(@FindBy(xpath = "[name=\"shipping_method\"]"))
           List<WebElement> shipMethodCheckbox;

   @FindBy(xpath = "//button[@onclick=\"shippingMethod.save()\"]")
           WebElement continueShipMethod;

   @FindAll(@FindBy(xpath = "//dt/input"))
           List<WebElement> paymentInfoCheckbox;

   @FindBy(xpath = "//button[@onclick=\"payment.save()\"]")
           WebElement continuePaymentMethod;
@FindBy(linkText = "Place Order")
    WebElement  placeOrderButton;

@FindAll(@FindBy(linkText = "Your order has been received."))
        List<WebElement> checkoutSuccessfulMsgList;

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

    public void addProductToCart() {
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

    public void proceedCheckOutProduct() {
        functionLibray.waitElemantPresent(countryDropdown);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("TR");
        stateInput.sendKeys("Istanbul");
        zipInput.sendKeys("34570");
        proceedToCheckOutButton.click();

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
