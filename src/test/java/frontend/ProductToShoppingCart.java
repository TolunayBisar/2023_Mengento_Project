package frontend;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductToShoppingCart {
    WebDriver driver;
    FunctionLibray functionLibray;
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
    WebElement accessoriesUpdatedMadinaLink;
    @FindBy(xpath = "//*[@class='category-products']/ul/li/a[@title='Retro Chic Eyeglasses']")
    WebElement productName;
    @FindBy(xpath = "//div/button[@title='Add to Cart']")
    WebElement addToCartLink;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addedShoppingCartSuccessMessage;
    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;
    @FindBy(xpath = "//a[@title='Log Out']")
    WebElement logoutLink;

    public ProductToShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
    }
    public void addProductToShoppingCart(){
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibray.waitElemantPresent(productName);
        productName.click();
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();

    }
    public boolean verifyForShoppingCartPage(){
        functionLibray.waitElemantPresent(addedShoppingCartSuccessMessage);
        System.out.println("Retro Chic Eyeglasses was added to your shopping cart.");
        return addedShoppingCartSuccessMessage.isDisplayed();

    }
    public void logOut(){
        functionLibray.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibray.waitElemantPresent(logoutLink);
        logoutLink.click();

    }
}
