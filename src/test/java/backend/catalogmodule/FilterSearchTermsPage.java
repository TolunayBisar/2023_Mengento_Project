package backend.catalogmodule;

import basefunc.BaseClass;
import basefunc.BaseClassForBackend;
import basefunc.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FilterSearchTermsPage  {
    WebDriver driver;

    FunctionLibrary functionLibrary;


    public FilterSearchTermsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement  catalog;
    @FindBy(xpath = "//span[text()='Search Terms']")
    WebElement searchTerms;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_search_query']")
    WebElement searchQuery;
    @FindBy(xpath = "//select[@name='store_id']")
    WebElement storeDropdown;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_num_results_from']")
    WebElement resultFrom;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_num_results_to']")
    WebElement resultTo;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_popularity_from']")
    WebElement numberOfUseFrom;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_popularity_to']")
    WebElement numberOfUseTo;
    @FindBy(xpath = "//input[@id='catalog_search_grid_filter_synonym_for']")
    WebElement synonymFor;
    @FindBy(xpath = "//select[@id='catalog_search_grid_filter_display_in_terms']")
    WebElement filterDisplay;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//span[@id='catalog_search_grid-total-count']")
    WebElement totalCount;
    @FindBy(xpath = "//span[text()='Reset Filter']")
    WebElement resetFilter;
//    @FindAll(
//            @FindBy(xpath = "td[@class='a-center ']/following-sibling::td")
//    )
//    List<WebElement> searchQueryList;
@FindAll(
        @FindBy(xpath = "//td[@class='a-center ']")
)
List<WebElement> storeList;
    @FindBy(xpath = "//tr[@class='even pointer']/td[2]")
    WebElement queryName;
    public void filterBySearchQuery(String SearchQuery){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(searchQuery);
        searchQuery.sendKeys(SearchQuery);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();
    }
    public void filterByStore(){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(storeDropdown);
        Select select = new Select(storeDropdown);
        select.selectByIndex(5);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();


    }
    public void filterByResult(String numberFrom,String numberTo){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(resultFrom);
        resultFrom.sendKeys(numberFrom);
        functionLibrary.waitElemantPresent(resultTo);
        resultTo.sendKeys(numberTo);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();

    }
    public void filterByUse(String numberFrom,String numberTo){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(numberOfUseFrom);
        numberOfUseFrom.sendKeys(numberFrom);
        functionLibrary.waitElemantPresent(numberOfUseTo);
        numberOfUseTo.sendKeys(numberTo);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();

    }
    public void filterBySynonym(String herf){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(synonymFor);
        synonymFor.sendKeys(herf);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();

    }
    public void filterBySuggestedTerms(){
        Actions actions = new Actions(driver);
        functionLibrary.waitElemantPresent(catalog);
        actions.moveToElement(catalog).click().build().perform();
        functionLibrary.waitElemantPresent(searchTerms);
        searchTerms.click();
        functionLibrary.waitElemantPresent(filterDisplay);
        Select displaySelect = new Select(filterDisplay);
        displaySelect.selectByIndex(0);
        functionLibrary.waitElemantPresent(searchButton);
        searchButton.click();
    }
    public boolean verifyFilter(){

        boolean flag;
        if (storeList.isEmpty()){
            System.out.println("no any filter result");

            flag = false;
        }
        else {
            int listNumber = storeList.size();

            System.out.println("there are " + listNumber + " records found");

            flag = true;
        }
     return flag;
    }



}
