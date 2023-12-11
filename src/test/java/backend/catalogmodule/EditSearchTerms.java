package backend.catalogmodule;

import basefunc.FunctionLibrary;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditSearchTerms {
    WebDriver driver;
    Faker faker;
    Actions actions;
    FunctionLibrary functionLibrary;

    @FindBy(id = "catalog_search_grid_filter_search_query")
    WebElement searchQuery;
    @FindBy(xpath = "//tbody/tr/td[last()]/a")
    WebElement gameEdit;
    @FindBy(id = "query_text")
    WebElement getSearchQuery;
    @FindBy(id = "num_results")
    WebElement numberOfResults;
    @FindBy(id = "popularity")
    WebElement numberOfUses;
    @FindBy(id = "synonym_for")
    WebElement synonymFor;
    @FindBy(id = "store_id")
    WebElement storeIDDropDown;
    @FindBy (xpath = "/html/body/div[1]/div[3]/div/div[2]/p/button[4]")
    WebElement saveSearchButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMassage;

    public EditSearchTerms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
        faker = new Faker();
    }

    public void setEditSearchTerms(){

        functionLibrary.waitElemantPresent(searchQuery);
        searchQuery.sendKeys("game");
        searchQuery.click();
        functionLibrary.waitElemantPresent(gameEdit);
        gameEdit.click();
        functionLibrary.waitElemantPresent(getSearchQuery);
        getSearchQuery.clear();
        functionLibrary.waitElemantPresent(getSearchQuery);
        getSearchQuery.sendKeys(faker.esports().league());
        functionLibrary.waitElemantPresent(storeIDDropDown);
        Select select = new Select(storeIDDropDown);
        select.selectByValue("16");
        functionLibrary.waitElemantPresent(numberOfResults);
        numberOfResults.sendKeys(faker.number().digits(7));
        functionLibrary.waitElemantPresent(numberOfUses);
        numberOfUses.sendKeys(faker.number().digits(5));
        functionLibrary.waitElemantPresent(synonymFor);
        synonymFor.sendKeys(faker.esports().game());
        functionLibrary.waitElemantPresent(saveSearchButton);
        saveSearchButton.click();

    }

    public boolean editSearchTermsSuccess(){
        functionLibrary.waitElemantPresent(successMassage);
        if (successMassage.isDisplayed())
            return true ;
        else return false;
    }

}
