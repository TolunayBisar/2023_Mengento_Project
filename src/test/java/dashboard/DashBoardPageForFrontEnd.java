package dashboard;
import basefunc.FunctionLibrary;
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
    FunctionLibrary functionLibrary;
    @FindBy(xpath = "//*[text()= \"My Dashboard\"]")
    WebElement myDashboardText;
    @FindBy(xpath = "//*[text()=\"My Dashboard\"]")
    WebElement myDashboardTextS;
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
    @FindBy(xpath ="//*[text()= \"Edit Account Information\"]")
    WebElement editAccountInformationText;
    @FindBy(xpath = "//a[text()=\"Address Book\"]")
    WebElement addressBookLink;

    public DashBoardPageForFrontEnd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public boolean verifyDashboardOpened() {
        functionLibrary.waitElemantPresent(myDashboardText);
        if (myDashboardText.isDisplayed()) {
            System.out.println("Megento FrontEnd succesfully opened");
        }
        return true;
    }
    public boolean verifyMyDashboardPageOpened(){
        functionLibrary.waitElemantPresent(myDashboardTextS);
        if (myDashboardTextS.isDisplayed()){
            System.out.println("Magento FrontEnd My Dashboard page successfully opened ");
            System.out.println(myDashboardTextS.getText());
            return true;
        }else {
            System.out.println("Magento Frontend login is failed ");
            return  false;
        }
    }
    public void clickAddressBookLink(){
        functionLibrary.waitElemantPresent(addressBookLink);
        addressBookLink.click();
    }

    public void clickOnMyAccountLink(){
        myAccountLink.click();
    }

    public void clickOnAccountDashboarLink(){
        accountDashboardLink.click();
    }
    public boolean verifyAccountInfo2() {
        functionLibrary.waitElemantPresent(editAccountInformationText);
        if (editAccountInformationText.isDisplayed()) {
            System.out.println("editAccountInformation page successfully opened");
        }
        return true;
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
