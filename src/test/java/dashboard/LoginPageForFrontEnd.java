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

<<<<<<< HEAD
    WebDriver driver;
    FunctionLibray functionLibrary;
Actions actions;
=======
    public WebDriver driver;
    FunctionLibrary functionLibrary;

>>>>>>> master

    @FindBy(linkText = "Welcome ")
    WebElement welcomeText;
    @FindBy(xpath = "//div[@class=\"block-title\"]/following-sibling::ul//a[@title=\"My Account\"]")
    WebElement myAccountLink;

<<<<<<< HEAD
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[3]/div/div[5]/ul/li[1]/a")
    WebElement getMyAccountLink;
=======


    @FindBy(xpath = "//span[text()='Account' and @class='label']")
    WebElement accountLink;
    @FindBy(css = "a[title='Log In']")
    WebElement loginLink;
>>>>>>> master
    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(id = "send2")
    WebElement loginButton;
    @FindBy(xpath = "//a[@class=\"skip-link skip-account\"]/span")
    WebElement accountLink;
    @FindBy(linkText = "Log Out")
    WebElement logOutLink;





    public LoginPageForFrontEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
<<<<<<< HEAD
        functionLibrary = new FunctionLibray(driver);
        actions =  new Actions(driver);

=======
        functionLibrary = new FunctionLibrary(driver);
>>>>>>> master
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
//
//
      functionLibrary.waitElemantPresent(myAccountLink);
      //functionLibrary.waitElemantPresent(getMyAccountLink);
      //functionLibrary.javaScripClick(myAccountLink);
       // actions.moveToElement(myAccountLink).click().build().perform();
 myAccountLink.click();
//         driver.findElement(By.xpath("//a/span[text()=\"Account\"]")).click();
       // driver.findElement(By.xpath("//div[@class=\"c\"]//li/a[text()=\"My Account\"]")).click();
//getMyAccountLink.click();
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }
<<<<<<< HEAD
    public void logOut(){
        functionLibrary.waitElemantPresent(accountLink);
        functionLibrary.javaScripClick(accountLink);
       // accountLink.click();
        functionLibrary.waitElemantPresent(logOutLink);
        functionLibrary.javaScripClick(logOutLink);
        //logOutLink.click();
    }
=======
    public void userLogin(String userEmail,String password){
        functionLibrary.waitElemantPresent(accountLink);
        accountLink.click();
        functionLibrary.waitElemantPresent(loginLink);
        loginLink.click();
        functionLibrary.waitElemantPresent(emailField);
        emailField.sendKeys(userEmail);
        functionLibrary.waitElemantPresent(passwordField);
        passwordField.sendKeys(password);
        functionLibrary.waitElemantPresent(loginButton);
        loginButton.click();
    }



>>>>>>> master
}
