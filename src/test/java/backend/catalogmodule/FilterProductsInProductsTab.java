package backend.catalogmodule;

import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForBackEnd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Random;

/**
 * @author : Anargul
 * @created : 12/7/2023,4:54 PM
 * @Email : abdanna369@gmail.com
 **/
public class FilterProductsInProductsTab {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    Random random;

    @FindBy(xpath = "//span[normalize-space()='Manage Categories']")
    WebElement ManageProductsTab;
    @FindAll(@FindBy(xpath = "//td[@class=\" a-right \"]"))
    List<WebElement> IDNumber;
    @FindBy(id = "productGrid_product_filter_entity_id_from")
    WebElement IDInputBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement Search;

    public FilterProductsInProductsTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public void FilterProductsInCategoryProduct() {
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
        dashBoardPageForBackEnd.clickOnCatalogTab();
        functionLibrary.waitElemantPresent( ManageProductsTab);
        ManageProductsTab.click();
        List<WebElement> AllProductsList = driver.findElements(By.xpath("//td[@class=\" a-right \"]"));
        int totoalLinks = AllProductsList.size();
        System.out.println("Total Links" + totoalLinks);
        Random random = new Random();
        WebElement toSlected = AllProductsList.get(random.nextInt(AllProductsList.size()));
        WebElement idInputBox = driver.findElement(By.xpath("productGrid_product_filter_entity_id_from"));
        idInputBox.sendKeys(toSlected.getText());
    }
}
