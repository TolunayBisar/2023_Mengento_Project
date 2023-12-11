package backend.salesmodule;
import basefunc.FunctionLibrary;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SalesManagerViewInvoices {
    WebDriver driver;
    FunctionLibrary functionalLibrary;
    Actions actions;
    Faker faker;

    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()='Sales']")
    WebElement salesTab;
    @FindBy(xpath = "//li[@class=\"  level1\"]/a/span[text()='Invoices']")
    WebElement invoicesLink;
    @FindAll(@FindBy(xpath = "//table[@id=\"sales_invoice_grid_table\"]//td[1]"))
    List<WebElement> allInvoices;
    @FindBy(css = "#sales_invoice_grid_table tbody tr:nth-child(1) td:nth-child(9) a")
    WebElement viewsLink;
    @FindBy(xpath = "//textarea[@id=\"history_comment\"]")
    WebElement commentTextArea;
    @FindBy(id="history_notify")
    WebElement notifyCheckBox;
    @FindBy(id = "history_visible")
    WebElement notifyCheckBox1;
    @FindBy(xpath = "//span[text()='Submit Comment']")
    WebElement submitButton;
    @FindBy(xpath = "//h3[@class=\"icon-head head-sales-invoice\"]")
    WebElement invoicesDisplayMessage;
    @FindBy(css = "p.super > span.separator")
    WebElement customerNotifiedMessage;

    public SalesManagerViewInvoices(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionalLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
        faker = new Faker();
    }

    public void viewInvoiceAndComment() {
        functionalLibrary.waitElemantPresent(salesTab);
        actions.pause(2000).perform();
        salesTab.click();
        functionalLibrary.waitElemantPresent(invoicesLink);
        actions.pause(2000).perform();
        invoicesLink.click();
    }
    public void viewInvoiceAndComment1() {
        functionalLibrary.waitElemantPresent(salesTab);
        actions.pause(2000).perform();
        salesTab.click();
        functionalLibrary.waitElemantPresent(invoicesLink);
        actions.pause(2000).perform();
        invoicesLink.click();
        int i=(int)  (Math.random() * 20);
        actions.click(allInvoices.get(i)).moveToElement(viewsLink).click().build().perform();
        functionalLibrary.waitElemantPresent(commentTextArea);
        actions.pause(2000).perform();
        commentTextArea.sendKeys(faker.lorem().sentence());
        functionalLibrary.waitElemantPresent(notifyCheckBox);
        actions.pause(2000).perform();
        notifyCheckBox.click();
        functionalLibrary.waitElemantPresent(notifyCheckBox1);
        actions.pause(2000).perform();
        notifyCheckBox1.click();
        functionalLibrary.waitElemantPresent(submitButton);
        actions.pause(2000).perform();
        submitButton.click();



    }
    public void verifyInvoicesComment() {
        functionalLibrary.waitElemantPresent(customerNotifiedMessage);
        if (customerNotifiedMessage.isDisplayed()) {
            System.out.println("comments page display and comments are submitted");
        } else {
            System.out.println("comments page is not opened");
        }
    }

    public void verifyInvoicesDisplay() {
        functionalLibrary.waitElemantPresent(invoicesDisplayMessage);
        if (invoicesDisplayMessage.isDisplayed()) {
            System.out.println("Invoices page is displayed ");
        } else {
            System.out.println("Invoices page is not opened");
        }
    }
}






