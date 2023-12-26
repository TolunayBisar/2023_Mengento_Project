package com.seleniummaster.ecommercetest.backend_page.customersmodule;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageForDeleteCustomer {
    WebDriver driver;
    FunctionLibrary functionalLibrary;
    Actions actions;

    @FindBy(xpath = "//*[@class='scalable delete']")
    WebElement deleteCustomer;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li")
    WebElement customerDeletedSuccessMessage;

    public PageForDeleteCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionalLibrary=new FunctionLibrary(driver);
        actions = new Actions(driver);
    }
    public void setDeleteCustomer(){
        WebElement editIcon = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]//following-sibling::td/a[text()='Edit']","Team3")));
        functionalLibrary.waitElemantPresent(editIcon);
        editIcon.click();
        functionalLibrary.waitElemantPresent(deleteCustomer);
        deleteCustomer.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();


    }
    public boolean verifyCustomerDeleted(){ //The customer has been deleted. //*[@id="messages"]/ul/li/ul/li
        if (customerDeletedSuccessMessage.isDisplayed())
            return true;
        else return false;
    }
}
