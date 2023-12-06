package backend.customersmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterCustomerGroupPage {
    WebDriver driver;
    FunctionLibray functionLibray;
    Actions actions;
    @FindBy(css="#customerGrid_filter_group")
    WebElement groupDropDown;
    @FindBy(css = "button[title='Search']")
    WebElement searchButton;
    @FindBy(css = "tr[class='even pointer']")
    WebElement infoForCustomersGroupMessage;
    @FindBy(css = "a[class=\"link-logout\"]")
    WebElement logOutLink;


    public FilterCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibray = new FunctionLibray(driver);
        actions = new Actions(driver);
    }

    public void filterCustomersGroup(){
        Select select = new Select(groupDropDown);
        select.selectByVisibleText("SDT2023Magento-Team3");
        String groupName = groupDropDown.getAttribute("value");
        System.out.println(" Group Name is: "+groupName);
        functionLibray.waitElemantPresent(searchButton);
        searchButton.click();
    }
    public boolean verifyFilterCustomersGroup(){
        functionLibray.waitElemantPresent(infoForCustomersGroupMessage);
        if (infoForCustomersGroupMessage.isDisplayed()){
            System.out.println(infoForCustomersGroupMessage.getText());
            System.out.println("Filter Customers Group was Successful!");
            return true;
        }else {
            System.out.println("Filter Customers Group was Not Successful!");
            return false;
        }
    }
    public void logOut(){
        functionLibray.waitElemantPresent(logOutLink);
        logOutLink.click();

    }
}
