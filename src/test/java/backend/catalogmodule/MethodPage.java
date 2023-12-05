package backend.catalogmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MethodPage {
    WebDriver driver;
    FunctionLibray functionLibray;
    Actions actions;
    @FindBy(xpath = "//ul[@id='nav']/li/a/span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul//span[text()='Search Terms']")
    WebElement searchTermsLink;
    @FindBy(xpath = "(//span[text()=\"Add New Search Term\"])[1]")
    WebElement addNewSearchTermLink;
    @FindBy(xpath = "//input[@id='query_text']")
    WebElement searchQueryFile;
    @FindBy(xpath = "//select[@id='store_id']")
    WebElement storeFile;
    @FindBy(xpath = "//input[@id='synonym_for']")
    WebElement synonymForFile;
    @FindBy(className = "validate-url input-text")
    WebElement redirectURLFile;
    @FindBy(xpath = "//select[@id='display_in_terms']")
    WebElement displayInSuggestedTerms;
    @FindBy(xpath = "(//span[text()=\"Save Search\"])[1]")
    WebElement saveSearchButton;
    @FindBy(xpath = "//li/span[text()='You saved the search term.']")
    WebElement successMessageForAddNewSearchTerm;

    public MethodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
}
