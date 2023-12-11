package backend.catalogmodule;


import basefunc.FunctionLibrary;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchTermsPage {
    WebDriver driver;
   FunctionLibrary functionLibrary;
    Actions actions;

    @FindBy(xpath = "(//span[text()=\"Add New Search Term\"])[1]")
    WebElement addNewSearchTermLink;
    @FindBy(xpath = "//input[@name='query_text']")
    WebElement searchQueryField;
    @FindBy(xpath = "//select[@id='store_id']")
    WebElement storeDropDown;
    @FindBy(xpath = "//input[@id='synonym_for']")
    WebElement synonymForField;
    @FindBy(css = "#redirect")
    WebElement redirectURLField;
    @FindBy(xpath = "//select[@id='display_in_terms']")
    WebElement displayDropDown;
    @FindBy(xpath = "(//span[text()=\"Save Search\"])[1]")
    WebElement saveSearchButton;
    @FindBy(xpath = "//li/span[text()='You saved the search term.']")
    WebElement successMessageForAddNewSearchTerm;


    public SearchTermsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
       functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }

    public void addNewSearchTerm(){
       functionLibrary.waitElemantPresent(addNewSearchTermLink);
        addNewSearchTermLink.click();
        DateTime time = new DateTime();
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd hh-mm-ss-SS");
       functionLibrary.waitElemantPresent(searchQueryField);
        searchQueryField.sendKeys(functionLibrary.generateFakeManufacture() +time.toString(dateFormat));
        Select select01 = new Select(storeDropDown);
        select01.selectByValue("8");
        functionLibrary.waitElemantPresent(synonymForField);
        synonymForField.sendKeys(functionLibrary.generateFakeManufacture());
       functionLibrary.waitElemantPresent(redirectURLField);
        redirectURLField.sendKeys(functionLibrary.storeURL);
        Select select02 = new Select(displayDropDown);
        select02.selectByVisibleText("Yes");
        functionLibrary.waitElemantPresent(saveSearchButton);
        saveSearchButton.click();

    }
    public boolean verifyAddNewSearchTem(){
        functionLibrary.waitElemantPresent(successMessageForAddNewSearchTerm);
        if (successMessageForAddNewSearchTerm.isDisplayed()){
            System.out.println(successMessageForAddNewSearchTerm.getText());
            System.out.println("Filter Customers Group was Successful!");
            return true;
        }else {
            System.out.println("Filter Customers Group was Not Successful!");
            return false;
        }
    }
}
