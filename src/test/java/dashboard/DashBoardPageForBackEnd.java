package dashboard;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:43
 * @Email :tolunay.bisar@gmail.com
 **/
public class DashBoardPageForBackEnd {
    public WebDriver driver;
    FunctionLibray functionLibrary;

    //customerModule
    @FindBy(xpath = "//p[contains(text(),'customermanager')]")
    WebElement loggedInAsCustomerManagerText;
    @FindBy(xpath = "//li[@class=\"parent level0\"]/a[@onClick=\"return false\"]/span[text()=\"Sales\"]")
    WebElement salesTab;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Catalog\"]")
    WebElement catalogTab;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Customers\"]")
    WebElement customerTab;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Promotions\"]")
    WebElement promotionTab;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Newsletter\"]")
    WebElement newsletterTab;
    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Reports\"]")
    WebElement reportsTab;

    //catalog Module
    @FindBy(xpath= "//p[contains(text(),'catalogmanager')]")
    WebElement loggedInAsCatalogManagerText;


    //Marketing Module
    @FindBy(xpath = "//p[contains(text(),'marketingmanager')]")
    WebElement loggedInAsMarketingManagerText;

    //sales Module
    @FindBy(xpath = "//p[contains(text(),'salesmanager')]")
    WebElement loggedInAsSalesManagerText;


    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"System\"]")
    WebElement systemTab;

    //store module
    @FindBy(xpath = "//p[contains(text(),'storemanager')]")
    WebElement loggedInAsStoreManagerText;

    // reporting module
    @FindBy(xpath ="//p[contains(text(),'reportingmanager')]")
    WebElement loggedInAsReportingManagerText;

    public DashBoardPageForBackEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);
    }

    public boolean verifyCustomerModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsCustomerManagerText);
        if (loggedInAsCustomerManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public boolean verifyCatalogModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsCatalogManagerText);
        if (loggedInAsCatalogManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public boolean verifyMarketingModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsMarketingManagerText);
        if (loggedInAsMarketingManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public boolean verifySalesModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsSalesManagerText);
        if (loggedInAsSalesManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public boolean verifyStoreModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsStoreManagerText);
        if (loggedInAsStoreManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public boolean verifyReportModuleDashboardOpened() {
        functionLibrary.waitElemantPresent(loggedInAsReportingManagerText);
        if (loggedInAsReportingManagerText.isDisplayed()) {
            System.out.println("Megento BackEnd succesfully opened");
        }
        return true;
    }

    public void clickOnSalesTab() {
        salesTab.click();
    }

    public void clickOnCatalogTab() {
        catalogTab.click();
    }

    public void clickOnCustomerTab() {
        customerTab.click();
    }

    public void clickOnPromotionTab() {
        promotionTab.click();
    }

    public void clickOnNewsletterTab() {
        newsletterTab.click();
    }

    public void clickOnReportTab() {
        reportsTab.click();
    }

    public void clickOnSystemTab() {
        systemTab.click();
    }


}
