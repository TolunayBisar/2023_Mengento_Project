package backend.customersmodule;
import basefunc.FunctionLibrary;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageForDeleteCustomer {
    WebDriver driver;

    FunctionLibrary functionLibrary;
    Actions actions;
    @FindBy(xpath ="//a[@href=https://ecommerce.unitedcoderapp.com/index.php/admin/customer/edit/id/760/key/1661a901184c0e296aceea9ff9d3cce8/]")
    WebElement customerEdit;
    @FindBy(className = "scalable delete")
    WebElement deleteCustomer;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li")
    WebElement customerDeletedSuccessMessage;

    public PageForDeleteCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
        //actions = new Actions(driver);
    }
    public void setDeleteCustomer(){
        functionLibrary.waitElemantPresent(customerEdit);
        customerEdit.click();
        functionLibrary.waitElemantPresent(deleteCustomer);
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
