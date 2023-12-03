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
    @FindBy(css = "#product-collection-image-433")
    WebElement choseProductLink ;

    @FindBy(css="#attribute92")
    WebElement colorLink;
    @FindBy(xpath="//*[@id=\"attribute92\"]/option[2]")
    WebElement colorOptionLink;

    @FindBy(css="#attribute186")
    WebElement shoeSizeLink;

    @FindBy(xpath = "//*[@id=\"attribute186\"]/option[4]")
    WebElement shoeSizeOptionLink;
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
        System.out.println("Retro Chic Eyeglasses was added to your shopping cart.");
        return addedShoppingCartSuccessMessage01.isDisplayed();

    }
    public void addProductsToShoppingCart02() {
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibray.waitElemantPresent(choseProductLink);
        choseProductLink.click();
        functionLibray.waitElemantPresent(colorLink);
        colorLink.click();
        functionLibray.waitElemantPresent(colorOptionLink);
        colorOptionLink.click();
        functionLibray.waitElemantPresent(shoeSizeLink);
        shoeSizeLink.click();
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage02(){
        functionLibray.waitElemantPresent(addedToShoppingCartSuccessMessage02);
        System.out.println("Dorian Perforated Oxford was added to your shopping cart.");
        return addedToShoppingCartSuccessMessage02.isDisplayed();

    }

    public void logOut(){
        functionLibray.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibray.waitElemantPresent(logoutLink);
        logoutLink.click();

    }
}
