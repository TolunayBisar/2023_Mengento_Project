package frontend;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductToShoppingCart {
    WebDriver driver;
    FunctionLibray functionLibray;
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
    @FindBy()
    WebElement addToCartLink04;
    @FindBy(xpath = "//*[@class=\"messages\"]")
    WebElement addToShoppingCartSuccessMessage04;


    public ProductToShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
        actions = new Actions(driver);
    }
    public void addProductToShoppingCart01(){
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        accessoriesUpdatedMadinaLink.click();
        functionLibray.waitElemantPresent(productName01);
        productName01.click();
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();

    }
    public boolean verifyForShoppingCartPage01(){
        functionLibray.waitElemantPresent(addToShoppingCartSuccessMessage01);
        System.out.println(" 1. "+addToShoppingCartSuccessMessage01.getText());
        return addToShoppingCartSuccessMessage01.isDisplayed();

    }
    public void addProductsToShoppingCart02() {
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        actions.moveToElement(accessoriesUpdatedMadinaLink).build().perform();
        shoesLink.click();
        functionLibray.waitElemantPresent(productName02);
        productName02.click();
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
    public void addProductsToShoppingCart03(){
        functionLibray.waitElemantPresent(accessoriesUpdatedMadinaLink);
        actions.moveToElement(accessoriesUpdatedMadinaLink).build().perform();
        bagsAndLuggageLink.click();
        functionLibray.waitElemantPresent(productName03);
        productName03.click();
        functionLibray.waitElemantPresent(monogramming);
        monogramming.sendKeys(functionLibray.generateFakeManufacture());
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage03(){
        functionLibray.waitElemantPresent(addToShoppingCartSuccessMessage03);
        System.out.println(" 3. "+addToShoppingCartSuccessMessage03.getText());
        return addToShoppingCartSuccessMessage03.isDisplayed();

    }
    public void addProductsToShoppingCart04() {
        functionLibray.waitElemantPresent(excellentHomeAndDecorLink);
        actions.moveToElement(excellentHomeAndDecorLink).build().perform();
        booksAndMusicLink.click();
        functionLibray.waitElemantPresent(productName04);
        productName04.click();
        functionLibray.waitElemantPresent(checkBox);
        checkBox.click();
        functionLibray.waitElemantPresent(addToCartLink);
        addToCartLink.click();
    }
    public boolean verifyForShoppingCartPage04(){
        functionLibray.waitElemantPresent(addToShoppingCartSuccessMessage04);
        System.out.println(" 4. "+addToShoppingCartSuccessMessage04.getText());
        return addToShoppingCartSuccessMessage04.isDisplayed();

    }
    public void logOut(){
        functionLibray.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibray.waitElemantPresent(logoutLink);
        logoutLink.click();

    }
}
