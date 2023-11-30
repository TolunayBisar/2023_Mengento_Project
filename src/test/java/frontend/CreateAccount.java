package frontend;

import basefunc.FunctionLibray;
import dashboard.DashBoardPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
    WebDriver driver;
    FunctionLibray functionLibray;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
    }
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[3]/div/div[5]/ul/li[1]/a")
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
        functionLibray.waitElemantPresent(myAccount);
        myAccount.click();
        functionLibray.waitElemantPresent(createAccountButton);
        createAccountButton.click();
        functionLibray.waitElemantPresent(firstName);
        firstName.sendKeys(FirstName);
        functionLibray.waitElemantPresent(lastName);
        lastName.sendKeys(LastName);
        functionLibray.waitElemantPresent(email);
        email.sendKeys(Email);
        functionLibray.waitElemantPresent(password);
        password.sendKeys(Password);
        functionLibray.waitElemantPresent(confirmPassword);
        confirmPassword.sendKeys(Password);
        functionLibray.waitElemantPresent(registerButton);
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
