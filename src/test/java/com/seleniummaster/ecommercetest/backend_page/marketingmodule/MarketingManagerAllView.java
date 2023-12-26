package com.seleniummaster.ecommercetest.backend_page.marketingmodule;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingManagerAllView {
    WebDriver driver;
    FunctionLibrary functionalLibrary;


    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Reports\"]")
    WebElement ReportsTab;
    @FindBy(xpath = "//span[text()='Reviews']")
    WebElement ReviewsLink;
    @FindBy(xpath = "//span[text()='Customers Reviews']")
    WebElement CustomerReviewsLink;
    @FindBy(xpath = "//span[text()='Products Reviews']")
    WebElement ProductReviewsLink;
    @FindBy(xpath = "//h3[@class=\"icon-head head-report-review-customer\"]")
    WebElement VerifyMessageForCustomerReviews;
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    WebElement VerifyMessageForProductReviews;

    public MarketingManagerAllView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionalLibrary = new FunctionLibrary(driver);

    }
    public void viewAllCustomerReviews() {
        functionalLibrary.waitElemantPresent(ReportsTab);
        ReportsTab.click();
        functionalLibrary.waitElemantPresent(ReviewsLink);
        ReviewsLink.click();
        functionalLibrary.waitElemantPresent(CustomerReviewsLink);
        CustomerReviewsLink.click();


    }



    public void viewAllProductReviews() {
        functionalLibrary.waitElemantPresent(ReportsTab);
        ReportsTab.click();
        functionalLibrary.waitElemantPresent(ReviewsLink);
        ReviewsLink.click();
        functionalLibrary.waitElemantPresent(ProductReviewsLink);
        ProductReviewsLink.click();



    }
    public boolean verifyCustomerReviewsOpened() {
        functionalLibrary.waitElemantPresent(VerifyMessageForCustomerReviews);
        if (VerifyMessageForCustomerReviews.isDisplayed()) {
            System.out.println("Customer Reviews page is opened");
            return true;
        } else {
            System.out.println("Customer Reviews page is not opened");
            return false;
        }
    }
    public boolean verifyProductReviewsOpened () {
        functionalLibrary.waitElemantPresent(VerifyMessageForProductReviews);
        if (VerifyMessageForProductReviews.isDisplayed()) {
            System.out.println("Product Reviews page is opened");
            return true;
        } else {
            System.out.println("Product Reviews page is not opened");
            return false;
        }

    }
}


