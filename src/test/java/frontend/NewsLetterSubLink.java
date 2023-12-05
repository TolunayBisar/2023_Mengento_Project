package frontend;

import basefunc.FunctionLibray;
import dashboard.DashBoardPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterSubLink {
    public WebDriver driver;
    FunctionLibray functionLibray;

    @FindBy(name="is_subscribed")
    WebElement checkBox;
    @FindBy(xpath = "//*[text()= \"My Dashboard\"]")
    WebElement welcomeMessage;

    public NewsLetterSubLink(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray=new FunctionLibray(driver);
    }


    public boolean verifyGeneralSubscription(){
        functionLibray.waitElemantPresent(checkBox);
        if (checkBox.isSelected()) {
            System.out.println("Check News Letter Subscriptions Success !!!");
        }
        return true;
    }
    public boolean verifyLoginSuccess(){
        functionLibray.waitElemantPresent(welcomeMessage);
        if (welcomeMessage.isDisplayed()){
            System.out.println("DashBoard Page Opened !");
        }
        return true;
    }

}



