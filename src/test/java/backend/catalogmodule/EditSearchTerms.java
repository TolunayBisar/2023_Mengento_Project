package backend.catalogmodule;

import basefunc.FunctionLibrary;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditSearchTerms {
    WebDriver driver;
    Select select;
    Faker faker= new Faker();
    Actions actions;
    FunctionLibrary functionLibrary;
    @FindBy(className = "active")
    WebElement catalogDrop;
    @FindBy(xpath ="//*[@id=\"nav\"]/li[1]/ul/li[5]/a/span")
    WebElement searchTermsButton;
    @FindBy(name = "search_query")
    WebElement searchQuery;
    @FindBy(xpath = "//*[@id=\"catalog_search_grid_table\"]/tbody/tr/td[9]/a")
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
    WebElement storeID;
    @FindBy(xpath = "//*[@id=\"store_id\"]/optgroup[10]")
    WebElement londonStore;
    @FindBy(className = "scalable save")
    WebElement saveSearchButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMassage;

    public EditSearchTerms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }

    public void setEditSearchTerms(){
//        functionLibrary.waitElemantPresent(catalogDrop);
//        catalogDrop.click();
//        functionLibrary.waitElemantPresent(searchTermsButton);
//        searchTermsButton.click();
        functionLibrary.waitElemantPresent(searchQuery);
        searchQuery.click();
        searchQuery.sendKeys("game");
        functionLibrary.waitElemantPresent(getSearchQuery);
        getSearchQuery.clear();
        getSearchQuery.sendKeys(faker.esports().league());
        functionLibrary.waitElemantPresent(gameEdit);
        gameEdit.click();
        functionLibrary.waitElemantPresent(storeID);
        storeID.click();
        functionLibrary.waitElemantPresent(londonStore);
        //londonStore.click();
        WebElement dateInput=driver.findElement(By.xpath(londonStore.getText()));
        Actions actions=new Actions(driver);
        actions.click(dateInput).build().perform();
        functionLibrary.waitElemantPresent(numberOfResults);
        numberOfResults.clear();

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
