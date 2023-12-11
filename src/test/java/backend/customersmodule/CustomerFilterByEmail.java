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
    @FindBy(id = "customerGrid_filter_email")
    WebElement EmailOFCustomer;
    @FindBy(xpath = "//td[@class=\" last\"]/a")
    WebElement ViewEditButton;
    @FindAll(@FindBy(xpath = "//tbody/tr"))
    WebElement EmailList;
    @FindBy(xpath = "//td[contains(text(),\"Simruh2021@gmail.com\")]")
    WebElement customersEmailAddress;
    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement SearchButton;
    public CustomerFilterByEmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }
    public Boolean filterCustomerByEmail(){
        functionLibrary.waitElemantPresent(customerTab);
        customerTab.click();
        functionLibrary.waitElemantPresent(ManageCustomers);
        ManageCustomers.click();
        functionLibrary.waitElemantPresent(EmailList);
        EmailList.getSize();
        String mailAdressToFilter = "Simruh2021@gmail.com";
        EmailOFCustomer.sendKeys(mailAdressToFilter);
        functionLibrary.waitElemantPresent(SearchButton);
        SearchButton.click();

        Boolean filterEmail = false;
        functionLibrary.waitElemantPresent(customersEmailAddress);
        if (customersEmailAddress.getText().
                equalsIgnoreCase(mailAdressToFilter)) {
            System.out.println("Admin view customers email ");
            return true;
        } else {
            System.out.println("filter customer is failed");
        }
        return filterEmail;
    }
    }
//    public boolean verifyNoFoundEmail() {
//        CustomerFilterByEmail filter = new CustomerFilterByEmail(driver);
//        Boolean filterEmail = false;
//        if (customersEmailAddress.getText().
//                equalsIgnoreCase(filter.filterCustomerByEmail())) {
//            System.out.println("Admin view customers email ");
//            return true;
//        } else if (!ViewEditButton.isDisplayed()) {
//            System.out.println("filter customer is failed");
//        }
//        return filterEmail;
//   }
