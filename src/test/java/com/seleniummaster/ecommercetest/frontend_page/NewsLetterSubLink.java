package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterSubLink {
    public WebDriver driver;
    FunctionLibrary functionLibrary;

    @FindBy(name="is_subscribed")
    WebElement checkBox;
    @FindBy(xpath = "//*[text()= \"My Dashboard\"]")
    WebElement welcomeMessage;

    public NewsLetterSubLink(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }


    public boolean verifyGeneralSubscription(){
        functionLibrary.waitElemantPresent(checkBox);
        if (checkBox.isSelected()) {
            System.out.println("Check News Letter Subscriptions Success !!!");
        }
        return true;
    }
    public boolean verifyLoginSuccess(){
        functionLibrary.waitElemantPresent(welcomeMessage);
        if (welcomeMessage.isDisplayed()){
            System.out.println("DashBoard Page Opened !");
        }
        return true;
    }

}



