package dashboard;
import basefunc.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:00
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginPageForFrontEnd {


    WebDriver driver;
    FunctionLibrary functionLibrary;
Actions actions;





    @FindBy(linkText = "Welcome ")
    WebElement welcomeText;
    @FindBy(xpath = "//div[@class=\"block-title\"]/following-sibling::ul//a[@title=\"My Account\"]")
    WebElement myAccountLink;


    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[3]/div/div[5]/ul/li[1]/a")
    WebElement getMyAccountLink;



    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;
    @FindBy(css = "a[title='Log In']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(id = "send2")
    WebElement loginButton;
    @FindBy(xpath = "//a[@class=\"skip-link skip-account\"]/span")
    WebElement accountLink1;
    @FindBy(linkText = "Log Out")
    WebElement logOutLink;





    public LoginPageForFrontEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        functionLibrary = new FunctionLibrary(driver);
        actions =  new Actions(driver);


    }

    public boolean verifyMengentoFrontEndOpen() {
        functionLibrary.waitElemantPresent(welcomeText);
        if (welcomeText.isDisplayed()) {
            System.out.println("Magento FrontEnd successfully opened");
        }
        return true;
    }



    // write login action
    public void enterUserName(String emailAdd) {
        functionLibrary.waitElemantPresent(emailField);
       emailField.sendKeys(emailAdd);
    }

    public void enterPassword(String password) {
        functionLibrary.waitElemantPresent(passwordField);
        passwordField.sendKeys(password);

    }

    public void clickLoginButton() {
        functionLibrary.waitElemantPresent(loginButton);
        loginButton.click();
    }

    public void logIn(String userName, String password) {

      functionLibrary.waitElemantPresent(myAccountLink);

 myAccountLink.click();

        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }

    public void userLogin(String userEmail,String password){
        functionLibrary.waitElemantPresent(accountLink1);
        accountLink1.click();
        functionLibrary.waitElemantPresent(loginLink);
        loginLink.click();
        functionLibrary.waitElemantPresent(emailField);
        emailField.sendKeys(userEmail);
        functionLibrary.waitElemantPresent(passwordField);
        passwordField.sendKeys(password);
        functionLibrary.waitElemantPresent(loginButton);
        loginButton.click();
    }




}
