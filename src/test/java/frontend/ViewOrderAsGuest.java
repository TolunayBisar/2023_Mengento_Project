package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author : Anargul
 * @created : 12/1/2023,4:14 PM
 * @Email : abdanna369@gmail.com
 **/
public class ViewOrderAsGuest extends BaseClass {

    WebDriver driver ;
    Faker faker = new Faker();
    FunctionLibray functionLibrary;
    @FindBy(xpath = "//a[text()=\"Lafayette Convertible Dress\"]")
    WebElement DressLink;
    @FindBy(css = "select#attribute92")
    WebElement colorDropDown;
    @FindBy(xpath = "//select[@id=\"attribute180\"]")
    WebElement sizeDropDown;
    @FindBy(id = "qty")
    WebElement quantityInputField;
    @FindBy(css = "div.add-to-cart-buttons button")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()=\"Cart\"]")
    WebElement shoppingCartTab;
    @FindBy(xpath= "//li[@class='success-msg']/ul/li/span")
    WebElement AddProductSuccessMessage;
    @FindAll(@FindBy(xpath = "//select[@id=\"attribute92\"]/option[@price=\"0\"]"))
    List<WebElement> optionsOfColorDropDown;
    @FindAll(@FindBy(xpath = "//select[@id=\"attribute180\"]/option[@price=\"0\"]"))
    List<WebElement> optionsOfSizeDropDown;

    public ViewOrderAsGuest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);
    }
    public void selectProduct(){
        functionLibrary.waitElemantPresent(DressLink);
        DressLink.click();
    }

    public void selectAColor(){
        int colorNumber = faker.random().nextInt(0,optionsOfColorDropDown.size()-1);
        functionLibrary.waitElemantPresent(colorDropDown);
        colorDropDown.click();
        functionLibrary.waitElemantPresent(optionsOfColorDropDown.get(colorNumber));
        optionsOfColorDropDown.get(colorNumber).click();
    }
    public void selectASize(){
        int sizeNumber = faker.random().nextInt(0,optionsOfSizeDropDown.size()-1);
        functionLibrary.waitElemantPresent(sizeDropDown);
        sizeDropDown.click();
        functionLibrary.waitElemantPresent(optionsOfSizeDropDown.get(sizeNumber));
        optionsOfSizeDropDown.get(sizeNumber).click();
    }
    public void enterQuantity(){
        //    int quantity = faker.random().nextInt(1, ProductObject.getQty());
        int quantity = faker.random().nextInt(1,10);
        functionLibrary.waitElemantPresent(quantityInputField);
        quantityInputField.clear();
        quantityInputField.sendKeys(String.valueOf(quantity));
    }
    public void clickOnAddToCart(){
        functionLibrary.waitElemantPresent(addToCartButton);
        addToCartButton.click();
    }

    public void userViewOrder(){
        functionLibrary.waitElemantPresent(shoppingCartTab);
        shoppingCartTab.click();
    }

    public boolean verifyRecentlyAddedItems() {
        Boolean added = false;
        if (AddProductSuccessMessage.isDisplayed()) {
            System.out.println("Orders successfully Added.");
            added = true;
        } else if (!AddProductSuccessMessage.isDisplayed())
            System.out.println("Please add your order");
        return added;
    }

}
