package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import com.github.javafaker.Faker;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : Anargul
 * @created : 12/2/2023,9:57 AM
 * @Email : abdanna369@gmail.com
 **/
public class ViewOrderAsRegistredUser extends BaseClass {
    WebDriver driver ;
    Faker faker = new Faker();
    FunctionLibray functionLibrary;
@FindBy(css= "a[class='skip-link skip-account'] span[class='label']")
    WebElement AccountLink;
    @FindBy(linkText = "My Account")
    WebElement myAccountLink;
    @FindBy(id = "//input[@id='email']")
    WebElement Email;
    @FindBy(id="//input[@id='pass']")
    WebElement Password;
    @FindBy(id = "//button[@id=\"send2\"]")
    WebElement LoginButton;
    @FindBy(linkText= "View Order")
    WebElement ViewOrderLink;

    public ViewOrderAsRegistredUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);
    }

    public void clickMyAccount(){
        functionLibrary.waitElemantPresent(AccountLink);
        AccountLink.click();
        functionLibrary.waitElemantPresent(myAccountLink);
        myAccountLink.click();

    }
    public  void enterEmail(){
        functionLibrary.waitElemantPresent(Email);
        Email.sendKeys(("Simruh2021@gmail.com"));

    }
    public  void enterPass(){
        functionLibrary.waitElemantPresent(Password);
        Email.sendKeys("Iloveme520");
    }

    public void clickLogin(){


        LoginButton.click();
    }
    public boolean registredUserViewOrder() {
        Boolean viewOrder = false;
        if (ViewOrderLink.isDisplayed()){
            System.out.println("Orders successfully Added.");
        viewOrder = true;
    }else if (!ViewOrderLink.isDisplayed())
                System.out.println("Orders successfully Added.");
        return false;
    }
}

