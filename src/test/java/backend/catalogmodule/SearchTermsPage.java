package backend.catalogmodule;

import basefunc.FunctionLibray;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchTermsPage {
    WebDriver driver;
    FunctionLibray functionLibray;
    Actions actions;
    @FindBy(xpath = "//ul[@id='nav']/li/a/span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul//span[text()='Search Terms']")
    WebElement searchTermsLink;
    @FindBy(xpath = "(//span[text()=\"Add New Search Term\"])[1]")
    WebElement addNewSearchTermLink;
    @FindBy(xpath = "//input[@name='query_text']")
    WebElement searchQueryField;
    @FindBy(xpath = "//select[@id='store_id']")
    WebElement storeField;
    @FindBy(xpath = "//input[@id='synonym_for']")
    WebElement synonymForField;
    @FindBy(css = "#redirect")
    WebElement redirectURLFile;
    @FindBy(xpath = "//select[@id='display_in_terms']")
    WebElement displayInSuggestedTerms;
    @FindBy(xpath = "(//span[text()=\"Save Search\"])[1]")
    WebElement saveSearchButton;
    @FindBy(xpath = "//li/span[text()='You saved the search term.']")
    WebElement successMessageForAddNewSearchTerm;

    public SearchTermsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
        actions = new Actions(driver);
    }

    public void addNewSearchTerm(){
        functionLibray.waitElemantPresent(catalogLink);
        actions.moveToElement(catalogLink).build().perform();
        searchTermsLink.click();
        functionLibray.waitElemantPresent(addNewSearchTermLink);
        addNewSearchTermLink.click();
        DateTime time = new DateTime();
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd hh-mm-ss-SS");
        functionLibray.waitElemantPresent(searchQueryField);
        searchQueryField.sendKeys(functionLibray.generateFakeManufacture() +time.toString(dateFormat));
        Select select01 = new Select(storeField);
        select01.selectByValue("8");
        functionLibray.waitElemantPresent(synonymForField);
        synonymForField.sendKeys(functionLibray.generateFakeManufacture());
        functionLibray.waitElemantPresent(redirectURLFile);
        redirectURLFile.sendKeys(functionLibray.storeURL);
        Select select02 = new Select(displayInSuggestedTerms);
        select02.selectByVisibleText("Yes");
        functionLibray.waitElemantPresent(saveSearchButton);
        saveSearchButton.click();

    }
    public boolean verifyAddNewSearchTem(){
        functionLibray.waitElemantPresent(successMessageForAddNewSearchTerm);
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
