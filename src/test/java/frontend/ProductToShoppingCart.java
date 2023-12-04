package frontend;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductToShoppingCart {
    WebDriver driver;
    FunctionLibray functionLibray;
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
    WebElement accessoriesUpdatedMadinaLink;
    @FindBy(id = "product-collection-image-553")
    WebElement productName;

    // (xpath = "//*[@class='category-products']/ul/li/a[@title='Retro Chic Eyeglasses']")
    @FindBy(css = "#product-collection-image-433")
    WebElement choseProductLink ;

    @FindBy(css="#attribute92")
    WebElement colorLink;

    @FindBy(css="#attribute186")
    WebElement shoeSizeLink;

    @FindBy(xpath = "//div/button[@title='Add to Cart']")
    WebElement addToCartLink;
    @FindBy(xpath = "//*[@class=\"success-msg\"]")
    WebElement addedToShoppingCartSuccessMessage02;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addedShoppingCartSuccessMessage01;
    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;
    @FindBy(xpath = "//a[@title='Log Out']")
    WebElement logoutLink;

    public ProductToShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
    }
    public void addProductToShoppingCart01(){
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibray.waitElemantPresent(productName);
        productName.click();
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();

    }
    public boolean verifyForShoppingCartPage01(){
        functionLibray.waitElemantPresent(addedShoppingCartSuccessMessage01);
        System.out.println(" 1. "+addedShoppingCartSuccessMessage01.getText());
        return addedShoppingCartSuccessMessage01.isDisplayed();

    }
    public void addProductsToShoppingCart02() {
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibray.waitElemantPresent(choseProductLink);
        choseProductLink.click();
        Select select1 = new Select(colorLink);
        select1.selectByVisibleText("Black");
        Select select2 = new Select(shoeSizeLink);
        select2.selectByVisibleText("10");
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage02(){
        functionLibray.waitElemantPresent(addedToShoppingCartSuccessMessage02);
        System.out.println(" 2. "+addedToShoppingCartSuccessMessage02.getText());
        return addedToShoppingCartSuccessMessage02.isDisplayed();

    }

    public void logOut(){
        functionLibray.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibray.waitElemantPresent(logoutLink);
        logoutLink.click();

    }
}
