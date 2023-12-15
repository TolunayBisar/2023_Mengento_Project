package backend.customersmodule;
import basefunc.FunctionLibrary;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssignCustomerToGroup extends BaseClassForBackend {
    WebDriver driver;
    FunctionLibrary functionalLibrary;
    Faker faker= new Faker();
    Actions actions;

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customersLink;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindBy(xpath = "//td[@class=\"form-buttons\"]/button")
    WebElement addNewCustomerButton;
    @FindBy(css = "#_accountgroup_id")
    WebElement groupDropDown;
    @FindBy(css = "#_accountfirstname")
    WebElement firstNameField;
    @FindBy(css = "#_accountlastname")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id=\"_accountpassword\"]")
    WebElement passwordField;
    @FindBy(css = "#_accountemail")
    WebElement emailField;
    @FindBy(xpath = "//*[@class=\"main-col-inner\"]//*[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//ul[@class=\"messages\"]/li/ul/li/span[text()='The customer has been saved.']")
    WebElement verifyMessageCustomerSaved;
    @FindBy(xpath = "//img[@id=\"_accountdob_trig\"]")
    WebElement dateOfBirthField;
    @FindBy(xpath= "//td[@class='button nav'][4] ")
    WebElement datePicker;





    public AssignCustomerToGroup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionalLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);

    }

    public void addNewCustomerToCustomerGroup(){

        functionalLibrary.waitElemantPresent(addNewCustomerButton);
        actions.pause(2000).perform();
        addNewCustomerButton.click();


        functionalLibrary.waitElemantPresent(groupDropDown);
        Select select = new Select(groupDropDown);
        select.selectByIndex(8);

        functionalLibrary.waitElemantPresent(firstNameField);
        actions.pause(2000).perform();
        firstNameField.sendKeys(faker.name().firstName());

        functionalLibrary.waitElemantPresent(lastNameField);
        actions.pause(2000).perform();
        lastNameField.sendKeys(faker.name().lastName());

        functionalLibrary.waitElemantPresent(emailField);
        actions.pause(2000).perform();
        emailField.sendKeys(faker.internet().emailAddress());
        functionalLibrary.waitElemantPresent(dateOfBirthField);
        actions.pause(2000).perform();
        dateOfBirthField.click();
        {functionalLibrary.waitElemantPresent(datePicker);
            actions.moveToElement(datePicker).click().perform();

            functionalLibrary.waitElemantPresent(passwordField);
            actions.pause(2000).perform();
            passwordField.sendKeys(faker.internet().password());
            functionalLibrary.waitElemantPresent(saveCustomerButton);
            actions.pause(2000).perform();
            saveCustomerButton.click();

        }
    }


    public boolean verifyCustomerAssignToCustomerGroup() {
        functionalLibrary.waitElemantPresent(verifyMessageCustomerSaved);
        if (verifyMessageCustomerSaved.isDisplayed()){
            return true;

        }else {
            System.out.println("Customer is assigned not successfully");
            return false;

        }
    }
}




