package com.seleniummaster.ecommercetest.backend_page.customersmodule;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterCustomerGroupPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Actions actions;
    @FindBy(css="#customerGrid_filter_group")
    WebElement groupDropDown;
    @FindBy(css = "button[title='Search']")
    WebElement searchButton;

    @FindAll(@FindBy(xpath = "customerGrid_table"))
    List<WebElement> rowsInCustomerTable;


    public FilterCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }

    public void filterCustomersGroup(){
        Select select = new Select(groupDropDown);
        select.selectByVisibleText("LondonTeam");
        String groupName = groupDropDown.getAttribute("value");
        System.out.println(" Group Name is: "+groupName);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();
    }
    public boolean verifyFilterCustomersGroup(){
      boolean flag= false;
      for (WebElement each: rowsInCustomerTable){
          if (each.getText().contains("LondonTeam")){
              flag=true;
          }
      }
       return flag;
    }

}
