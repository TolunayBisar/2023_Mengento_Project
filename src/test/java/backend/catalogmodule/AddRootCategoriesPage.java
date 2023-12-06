package backend.catalogmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddRootCategoriesPage {
    WebDriver driver;
    FunctionLibray functionLibray;
    Select select;
    @FindBy(id = "group_4name")
    WebElement nameField;
    @FindBy(id = "group_4is_active")
    WebElement isActiveField;
    @FindBy(id = "group_4include_in_menu")
    WebElement includeInNavigationMenuField;
    @FindBy(xpath = "//*[text()=\"Save Category\"]")
    WebElement saveCategoryButton;
    @FindBy(xpath = "//li[@class=\"success-msg\"]/ul/li")
    WebElement successMassage;

    public AddRootCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray=new FunctionLibray(driver);
    }
    public void addRootCategoryMethod( ){
        functionLibray.waitElemantPresent(nameField);
        nameField.sendKeys(functionLibray.generateFakerDepartment());
        System.out.println(functionLibray.generateFakerDepartment());
        functionLibray.waitElemantPresent(isActiveField);
        select=new Select(isActiveField);
        select.selectByVisibleText("Yes");
        functionLibray.waitElemantPresent(includeInNavigationMenuField);
        select=new Select(includeInNavigationMenuField);
        select.selectByValue("1");
        functionLibray.waitElemantPresent(saveCategoryButton);
        saveCategoryButton.click();

    }
    public boolean verifyRootCategoryAdded(){
        functionLibray.waitElemantPresent(successMassage);
        if (successMassage.isDisplayed()){
            System.out.println(successMassage.getText());
            return true;
        }else {
            System.out.println("Add Root Category is Failed ");
            return false;
        }
    }
}
