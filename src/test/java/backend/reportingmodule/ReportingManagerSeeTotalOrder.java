package backend.reportingmodule;
import basefunc.FunctionLibrary;
import com.github.javafaker.Faker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ReportingManagerSeeTotalOrder {
    WebDriver driver;
    FunctionLibrary functionalLibrary;
    Actions actions;
    Faker faker;

    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Reports\"]")
    WebElement reportsTab;
    @FindBy(css = "#nav > li:nth-child(2) > ul > li:nth-child(1) > a > span\n")
    WebElement salesLink;
    @FindBy(xpath = "//li[@class=\"  level2\"]/a/span[text()='Orders']")
    WebElement ordersLink;
    @FindBy(xpath = "//img[@id=\"sales_report_from_trig\"]")
    WebElement dateSelectButton;
    @FindBy(xpath = "//tr[@class=\"headrow\"]/td[@class=\"button nav\"]")
    WebElement yearSelectLink;
    @FindBy(xpath = "//img[@id=\"sales_report_to_trig\"]")
    WebElement dateSelectButton1;
    @FindBy(xpath = "//button[@title=\"Show Report\"]/span/span/span[text()='Show Report']")
    WebElement showReportButton;
    @FindBy(xpath = "//*[@class=\"icon-head head-report-sales-sales\"]")
    WebElement VerifyMessageForTotalOrder;
    @FindBy(xpath = "//label[@for=\"sales_report_to\"]")
    WebElement goToLink;
    @FindBy(css = ".today")
    WebElement monthSelectLink;

    public ReportingManagerSeeTotalOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionalLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
        faker = new Faker();
    }
    public void seeTotalOrder(){

        functionalLibrary.waitElemantPresent(reportsTab);
        reportsTab.click();
        functionalLibrary.waitElemantPresent(salesLink);
        salesLink.click();
        functionalLibrary.waitElemantPresent(ordersLink);
        ordersLink.click();
        functionalLibrary.waitElemantPresent(dateSelectButton);
        dateSelectButton.click();
        functionalLibrary.waitElemantPresent(yearSelectLink);
        actions.moveToElement(yearSelectLink).click().build().perform();
        functionalLibrary.waitElemantPresent(goToLink);
        actions.moveToElement(goToLink).click();
        actions.pause(2000).build().perform();
        functionalLibrary.javaScripClick(dateSelectButton1);
        functionalLibrary.waitElemantPresent(monthSelectLink);
        monthSelectLink.click();
        actions.pause(2000).build().perform();
        functionalLibrary.waitElemantPresent(showReportButton);
        showReportButton.click();


    }
    public void verifyMessageForTotalOrder(){
        functionalLibrary.waitElemantPresent(VerifyMessageForTotalOrder);
        if(VerifyMessageForTotalOrder.getText().contains("Total Ordered Report")){
            System.out.println("Orders Report is displayed,that is correct");
        }
        else{
            System.out.println("Orders Report is not displayed");
        }
        System.out.println(VerifyMessageForTotalOrder.getText());
    }


}





