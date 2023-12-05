package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

public class CustomerInfoPage extends BaseClass {

    FunctionLibray functionPage;

    public CustomerInfoPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionLibray(driver);

    }




    @FindBy(xpath = "//a[text()='Accessories Updated Madina']")
    WebElement accessoriesLink;

    @FindBy(id = "product-collection-image-372")
    WebElement islaHandbagLink;

    @FindBy (xpath = "//*[@title='Add to Cart' and @onclick='productAddToCartForm.submit(this)']")
    WebElement addToCartLink;

    @FindBy(xpath = "(//*[@class='label' and contains (text(), 'Cart')])[1]")
    WebElement cartLink;
    @FindBy(linkText = "VIEW SHOPPING CART")
    WebElement viewShoppingCart;

    @FindBy (xpath = "(//a[@title=\"Edit item parameters\" and contains (text(),'Edit')])[2]")
    WebElement shoppingCartEdit;

    @FindBy (xpath = "//*[@id='options_4_text']")
    WebElement descriptionField;
    @FindBy (xpath = "//*[@id=\"qty\" or @title=\"Qty\"]")
    WebElement qtyField;

    @FindBy (xpath = "//*[@title=\"Update Cart\"]")
    WebElement updateShoppingCart;

    @FindBy (xpath ="//li[@class=\"success-msg\"]" )
    WebElement successMessage;
    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;

    @FindBy(xpath = "//a[@title=\"Log Out\"]")
    WebElement logUitLink;






    public void setViewShoppingCart(){
        Random random=new Random();
        int randomQty=random.nextInt(3)+1;
        functionPage.waitElemantPresent(accessoriesLink);
        accessoriesLink.click();
        functionPage.waitElemantPresent(islaHandbagLink);
        islaHandbagLink.click();
        functionPage.waitElemantPresent(addToCartLink);
        addToCartLink.click();
        functionPage.waitElemantPresent(cartLink);
        cartLink.click();
        functionPage.waitElemantPresent(viewShoppingCart);
        viewShoppingCart.click();
        functionPage.waitElemantPresent(shoppingCartEdit);
        shoppingCartEdit.click();
//        functionPage.waitElemantPresent(descriptionField);
//        descriptionField.clear();
//        descriptionField.sendKeys(functionPage.generateFakeManufacture());
        functionPage.waitElemantPresent(qtyField);
        qtyField.clear();
        qtyField.sendKeys(String.valueOf(randomQty));
        functionPage.waitElemantPresent(updateShoppingCart);
        updateShoppingCart.click();

    }

    public void verifyUpdate(){
        functionPage.waitElemantPresent(successMessage);
        String actualSuccessMessage=successMessage.getText();
        String expectedKeyWord="updated in your shopping cart";
        Assert.assertTrue(actualSuccessMessage.contains(expectedKeyWord),"Success message not found");

    }

    public void logUit(){
        functionPage.waitElemantPresent(accountLink);
        accountLink.click();
        functionPage.waitElemantPresent(logUitLink);
        logUitLink.click();
    }



}
