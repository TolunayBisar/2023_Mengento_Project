package dashboard;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:00
 * @Email :tolunay.bisar@gmail.com
 **/
public class DashBoardPageForFrontEnd {
    public WebDriver driver;
    FunctionLibray functionLibrary;
    @FindBy(linkText = "My Dashboard")
    WebElement myDashboardText;
    @FindBy(xpath = "//span[text()=\"My Account\"]")
    WebElement myAccountLink;
    @FindBy(xpath ="//strong[text()=\"Account Dashboard\"]" )
    WebElement accountDashboardLink;

    @FindBy(xpath ="//a[text()=\"Account Information\"]" )
    WebElement accountInformationLink;
    @FindBy(xpath ="//a[text()=\"Address Book\"]" )
    WebElement addBookLink;

    @FindBy(xpath ="//a[text()=\"My Product Reviews\"]" )
    WebElement myProductReviewLink;

    @FindBy(xpath ="//div[@class=\"block-content\"]//a[text()=\"My Wishlist\"]" )
    WebElement myWishListLink;

    @FindBy(xpath ="//div[@class=\"block-content\"]//a[text()=\"Newsletter Subscriptions\"]" )
    WebElement newsletterSubscribedLink;

    @FindBy(xpath ="//div[@class=\"block-content\"]//a[text()=\"My Downloadable Products\"]" )
    WebElement myDownloadableProductLink;
    @FindBy(xpath ="//div[@class=\"block-content\"]//a[text()=\"My Orders\"]" )
    WebElement myOrderLink;


    public DashBoardPageForFrontEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibray(driver);
    }

    public boolean verifyDashboardOpened() {
        functionLibrary.waitElemantPresent(myDashboardText);
        if (myDashboardText.isDisplayed()) {
            System.out.println("Megento FrontEnd succesfully opened");
        }
        return true;
    }

    public void clickOnMyAccountLink(){
        myAccountLink.click();
    }

    public void clickOnAccountDashboarLink(){
        accountDashboardLink.click();
    }

    public void clickOnAccountInformationLink(){
        accountInformationLink.click();
    }
    public void clickOnAddressBookLink(){
        addBookLink.click();
    }

    public void clickOnMyOrderLink(){
        myOrderLink.click();
    }

    public void clickOnMyProductReviewsLink(){
        myProductReviewLink.click();
    }

    public void clickOnMyWishLink(){
        myWishListLink.click();
    }

    public void clickOnNewsletterLink(){
        newsletterSubscribedLink.click();
    }

    public void clickOnMyDownloadableProductLink(){
        myDownloadableProductLink.click();
    }




}
