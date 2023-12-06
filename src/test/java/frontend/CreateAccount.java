package frontend;

import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }
    @FindBy(xpath = "//div[@class=\"block-title\"]/following-sibling::ul//a[@title=\"My Account\"]")
    WebElement myAccount;
    @FindBy(xpath = "//*[@title='Create an Account']")
    WebElement createAccountButton;
    @FindBy(id="firstname")
    WebElement firstName;
    @FindBy(id = "lastname")
    WebElement lastName;
    @FindBy(id = "email_address")
    WebElement email;
    @FindBy(id  = "password")
    WebElement password;
    @FindBy(id = "confirmation")
    WebElement confirmPassword;
    @FindBy(xpath = "//*[@title='Register'  and @class='button']")
    WebElement registerButton;
    @FindBy(xpath = "//li[@class='success-msg']")
    WebElement successMessageRegister;
    public void creatAccount(String FirstName,String LastName,String Email,String Password){
        functionLibrary.waitElemantPresent(myAccount);
        myAccount.click();
        functionLibrary.waitElemantPresent(createAccountButton);
        createAccountButton.click();
        functionLibrary.waitElemantPresent(firstName);
        firstName.sendKeys(FirstName);
        functionLibrary.waitElemantPresent(lastName);
        lastName.sendKeys(LastName);
        functionLibrary.waitElemantPresent(email);
        email.sendKeys(Email);
        functionLibrary.waitElemantPresent(password);
        password.sendKeys(Password);
        functionLibrary.waitElemantPresent(confirmPassword);
        confirmPassword.sendKeys(Password);
        functionLibrary.waitElemantPresent(registerButton);
        registerButton.click();

    }
    public boolean verifyEditSuccessfully(){
        if (successMessageRegister.isDisplayed()){
            System.out.println("Account succesully created");
            return true;
        }else {
            System.out.println("Information edit failed");
            return false;
        }

    }


}
