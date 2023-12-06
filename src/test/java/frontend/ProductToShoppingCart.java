package frontend;

import basefunc.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductToShoppingCart {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Actions actions;
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
    WebElement accessoriesUpdatedMadinaLink;
    @FindBy(xpath = "//div/button[@title='Add to Cart']")
    WebElement addToCartLink;
    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;
    @FindBy(xpath = "//a[@title='Log Out']")
    WebElement logoutLink;

    // product01
    @FindBy(id = "product-collection-image-553")
    WebElement productName01;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addToShoppingCartSuccessMessage01;

    // product02
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/ul/li[4]/a")
    WebElement shoesLink;
    @FindBy(css = "#product-collection-image-433")
    WebElement productName02;
    @FindBy(css="#attribute92")
    WebElement colorLink;
    @FindBy(css="#attribute186")
    WebElement shoeSizeLink;
    @FindBy(xpath = "//*[@class=\"success-msg\"]")
    WebElement addedToShoppingCartSuccessMessage02;

    // product03
    @FindBy(xpath = "//ul/li[last()]/a[text()='Bags & Luggage']")
    WebElement bagsAndLuggageLink;
    @FindBy(id="product-collection-image-370")
    WebElement productName03;
    @FindBy(id="options_4_text")
    WebElement monogramming;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addToShoppingCartSuccessMessage03;

    //product04
    @FindBy(xpath = "//*[@id='nav']/ol/li[@class='level0 nav-2 parent']/a")
    WebElement excellentHomeAndDecorLink;
    @FindBy(xpath = "//*[@id='nav']/ol/li[2]/ul/li[2]/a")
    WebElement booksAndMusicLink;
    @FindBy(id = "product-collection-image-448")
    WebElement productName04;
    @FindBy(name = "links[]")
    WebElement checkBox;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addToShoppingCartSuccessMessage04;


    public ProductToShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }
    public void addProductToShoppingCart01(){
        functionLibrary.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibrary.waitElemantPresent(productName01);
        productName01.click();
        functionLibrary.waitElemantPresent(addToCartLink);
        addToCartLink.click();

    }
    public boolean verifyForShoppingCartPage01(){
        functionLibrary.waitElemantPresent(addToShoppingCartSuccessMessage01);
        System.out.println(" 1. "+addToShoppingCartSuccessMessage01.getText());
        return addToShoppingCartSuccessMessage01.isDisplayed();

    }
    public void addProductsToShoppingCart02() {
        functionLibrary.waitElemantPresent(accessoriesUpdatedMadinaLink);
        actions.moveToElement(accessoriesUpdatedMadinaLink).build().perform();
        shoesLink.click();
        functionLibrary.waitElemantPresent(productName02);
        productName02.click();
        Select select1 = new Select(colorLink);
        select1.selectByVisibleText("Black");
        Select select2 = new Select(shoeSizeLink);
        select2.selectByVisibleText("10");
        functionLibrary.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage02(){
        functionLibrary.waitElemantPresent(addedToShoppingCartSuccessMessage02);
        System.out.println(" 2. "+addedToShoppingCartSuccessMessage02.getText());
        return addedToShoppingCartSuccessMessage02.isDisplayed();

    }
    public void addProductsToShoppingCart03(){
        functionLibrary.waitElemantPresent(accessoriesUpdatedMadinaLink);
        actions.moveToElement(accessoriesUpdatedMadinaLink).build().perform();
        bagsAndLuggageLink.click();
        functionLibrary.waitElemantPresent(productName03);
        productName03.click();
        functionLibrary.waitElemantPresent(monogramming);
        monogramming.sendKeys(functionLibrary.generateFakeManufacture());
        functionLibrary.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage03(){
        functionLibrary.waitElemantPresent(addToShoppingCartSuccessMessage03);
        System.out.println(" 3. "+addToShoppingCartSuccessMessage03.getText());
        return addToShoppingCartSuccessMessage03.isDisplayed();

    }
    public void addProductsToShoppingCart04() {
        functionLibrary.waitElemantPresent(excellentHomeAndDecorLink);
        actions.moveToElement(excellentHomeAndDecorLink).build().perform();
        booksAndMusicLink.click();
        functionLibrary.waitElemantPresent(productName04);
        productName04.click();
        functionLibrary.waitElemantPresent(checkBox);
        checkBox.click();
        functionLibrary.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage04(){
        functionLibrary.waitElemantPresent(addToShoppingCartSuccessMessage04);
        System.out.println(" 4. "+addToShoppingCartSuccessMessage04.getText());
        return addToShoppingCartSuccessMessage04.isDisplayed();

    }
    public void logOut(){
        functionLibrary.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibrary.waitElemantPresent(logoutLink);
        logoutLink.click();

    }
}
