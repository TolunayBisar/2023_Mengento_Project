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
    FunctionLibrary functionalLibrary;
    Actions actions;
    @FindBy(xpath ="//*[@id=\"customerGrid_table\"]/tbody/tr[18]/td[12]/a")  // if u want start change element!
    WebElement customerEdit;
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
        functionalLibrary.waitElemantPresent(customerEdit);
        customerEdit.click();
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
