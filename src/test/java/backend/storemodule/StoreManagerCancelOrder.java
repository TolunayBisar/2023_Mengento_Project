package backend.storemodule;
import basefunc.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StoreManagerCancelOrder {
    WebDriver driver;
    FunctionLibrary functionalLibrary;
    Actions actions;

    @FindAll(@FindBy(xpath = "//table[@id=\"sales_order_grid_table\"]//td[2]"))
    List<WebElement> allOrders;
    @FindBy(xpath = "//*[@title=\"Cancel\"]/span/span/span")
    WebElement cancelButton;
    @FindBy(xpath = "//span[normalize-space()='The order has been cancelled.']")
    WebElement verifyMessageOrderCanceled;
    @FindBy(xpath = "//span[@id=\"order_status\"]")
    WebElement orderStatusCanceled;
    @FindBy(xpath = "//img[@alt=\"Go to Next page\"]")
    WebElement nextPageButton;

    public StoreManagerCancelOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionalLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
    }

    public void cancelOrder() {
        WebElement salesButton = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(salesButton));
        salesButton.click();
        WebElement ordersLink = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        wait.until(ExpectedConditions.visibilityOf(ordersLink));
        ordersLink.click();
        functionalLibrary.waitElemantPresent(nextPageButton);
        actions.moveToElement(nextPageButton).click().build().perform();
        int i=(int) (Math.random()*20);
        actions.click(allOrders.get(i)).build().perform();
        functionalLibrary.waitElemantPresent(cancelButton);
        cancelButton.click();
        driver.switchTo().alert().accept();

    }
    public boolean verifyCancelled() {
        if (orderStatusCanceled.isDisplayed()){
            System.out.println("Order has been cancelled,you can`t cancel it again");
            return true;
        } else if(verifyMessageOrderCanceled.isDisplayed()){
            System.out.println("Order has been successfully cancelled");
            return true;
        }
        return false;
    }


}





