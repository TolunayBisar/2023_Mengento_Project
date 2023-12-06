package backend.customersmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomersByState {
    WebDriver driver;
    FunctionLibray functionLibray;
    //Actions actions;
//    @FindBy(xpath = "//ul[@id=\"nav\"]/li[4]/a/span")
//    WebElement customersLink;
//    @FindBy(xpath = "//*[text()=\"Manage Customers\"]")
//    WebElement manageCustomersLink;

    @FindBy(id = "customerGrid_filter_billing_region")
    WebElement stateBox;
    @FindBy(xpath = "//*[text()=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//tr[@class='even pointer']/td[4]")
    WebElement searchedCustomerInfo;


    public FilterCustomersByState(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray=new FunctionLibray(driver);
        //actions=new Actions(driver);
    }
    public void filterCustomersByStateMethod(String stateName){
//        functionLibray.waitElemantPresent(customersLink);
//        actions.clickAndHold(customersLink).build().perform();
//        functionLibray.waitElemantPresent(manageCustomersLink);
//        manageCustomersLink.click();
        functionLibray.waitElemantPresent(stateBox);
        stateBox.sendKeys(stateName);
        functionLibray.waitElemantPresent(searchButton);
        searchButton.click();
    }
    public boolean verifyCustomersFilteredByState(){
        functionLibray.waitElemantPresent(searchedCustomerInfo);
        if (searchedCustomerInfo.isDisplayed()){
            System.out.println(searchedCustomerInfo.getText());
            System.out.println("Customer successfully filtered by stated !");
        return true;
        }else{
            System.out.println("Filter Customer By state test is failed ");
            return false;
        }
    }
}
