package backend.customersmodule;


import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForBackEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : Anargul
 * @created : 12/5/2023,7:41 PM
 * @Email : abdanna369@gmail.com
 **/
public class CustomerFilterByEmail {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    @FindBy(xpath = "//span[text()=\"Customers\"]")
    WebElement customerTab;
    @FindBy(xpath = "//span[text()=\"Manage Customers\"]")
    WebElement ManageCustomers;
    @FindBy(id ="customerGrid_filter_email")
    WebElement EmailOFCustomer;
@FindBy(xpath = "//td[@class=\" last\"]/a")
    WebElement ViewEditButton;
    @FindAll(@FindBy(xpath="//tbody/tr"))
    WebElement EmailList;
    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement SearchButton;
    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    WebElement checkBox;

    public CustomerFilterByEmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public void filterCustomerByEmail(){
        functionLibrary.waitElemantPresent(customerTab);
        customerTab.click();
        functionLibrary.waitElemantPresent(ManageCustomers);
        ManageCustomers.click();
    functionLibrary.waitElemantPresent(EmailList);
    EmailList.getSize();
    String mailNameToFilter = "Simruh";
    EmailOFCustomer.sendKeys(mailNameToFilter);
    functionLibrary.waitElemantPresent(SearchButton);
    SearchButton.click();
}
    public boolean verifyNoFoundEmail() {
        Boolean filterEmail = false;
        functionLibrary.waitElemantPresent(ViewEditButton);
        if (ViewEditButton.isDisplayed()) {
            System.out.println("Admin view customers email ");
            return true;
        }else if  (!ViewEditButton.isDisplayed()){
            System.out.println("filter customer is failed");
    }
        return filterEmail;
    }
}