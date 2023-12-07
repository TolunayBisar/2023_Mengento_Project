package frontend;

import basefunc.FunctionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class ViewMyProductReviewsPage {
        WebDriver driver;
        FunctionLibrary functionLibray;

        @FindBy(xpath ="//a[text()=\"My Product Reviews\"]")
        WebElement myProductReviewsLink;
        @FindBy(xpath = "//td/a[text()=\"View Details\"]")
        WebElement viewDetailsButton;
        @FindBy(xpath = "//*[@class=\"my-account\"]/div/div/h1")
        WebElement verifyMessageReviewDetails;



        public ViewMyProductReviewsPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
            functionLibray = new FunctionLibrary(driver);

        }

        public void myProductsReviewLinkAndViewDetails(){
            functionLibray.waitElemantPresent(myProductReviewsLink);
            myProductReviewsLink.click();


        }
        public void myProductReviewDetails(){

            functionLibray.waitElemantPresent(viewDetailsButton);
            viewDetailsButton.click();

        }


        public boolean verifyReviewDetails() {
            functionLibray.waitElemantPresent(verifyMessageReviewDetails);
            return  verifyMessageReviewDetails.isDisplayed();


        }
    }




