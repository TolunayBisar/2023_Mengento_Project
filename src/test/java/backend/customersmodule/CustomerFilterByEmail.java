package backend.customersmodule;

import basefunc.FunctionLibray;
import dashboard.DashBoardPageForBackEnd;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
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
    FunctionLibray functionLibray;
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
        functionLibray = new FunctionLibray(driver);
    }

    public void filterCustomerByEmail(){
        functionLibray.waitElemantPresent(customerTab);
        customerTab.click();
        functionLibray.waitElemantPresent(ManageCustomers);
        ManageCustomers.click();
    functionLibray.waitElemantPresent(EmailList);
    EmailList.getSize();
    String mailNameToFilter = "Simruh";
    EmailOFCustomer.sendKeys(mailNameToFilter);
    functionLibray.waitElemantPresent(SearchButton);
    SearchButton.click();
}
    public boolean verifyNoFoundEmail() {
        Boolean filterEmail = false;
        functionLibray.waitElemantPresent(ViewEditButton);
        if (ViewEditButton.isDisplayed()) {
            System.out.println("Admin view customers email ");
            return true;
        }else if  (!ViewEditButton.isDisplayed()){
            System.out.println("filter customer is failed");
    }
        return filterEmail;
    }
}