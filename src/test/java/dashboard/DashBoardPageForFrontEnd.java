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

    // create an account
    @FindBy(xpath = "//span[text()=\"My Account\"]")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@id='header']/div/div/div/a//span[@class='label']")
    WebElement accountLink;
    @FindBy(xpath = "//*[@id='header-account']/div/ul/li//a[@title='My Account']")
    WebElement myAccountLinkTab;
    @FindBy(xpath = "//*[@title='Create an Account']")
    WebElement createAnAccountLink;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='middlename']")
    WebElement middleNameField;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email_address']")
    WebElement emailAddressField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='confirmation']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@id='is_subscribed']")
    WebElement signUpForNewsletterBox;
    @FindBy(xpath = "//button[@title='Register']")
    WebElement registerLink;
    // please do not delete !


    @FindBy(linkText = "My Dashboard")
    WebElement myDashboardText;

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



    public void createAnAccountMesut(String firstname, String middleName, String lastName,
                                     String emailAddress, String password, String confirmPassword){
        accountLink.click();
        myAccountLinkTab.click();
        createAnAccountLink.click();
        firstNameField.sendKeys(firstname);
        middleNameField.sendKeys(middleName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signUpForNewsletterBox.click();
        registerLink.click();
    }


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
