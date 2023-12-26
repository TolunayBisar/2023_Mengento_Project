package com.seleniummaster.ecommercetest.backend_page.catalogmodule;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditRootCategory {
    WebDriver driver;
   FunctionLibrary functionLibrary;
    Actions actions;
    Faker faker;

    @FindBy(xpath = "//a[@onClick=\"return false\"]/span[text()=\"Catalog\"]")
    WebElement catalogTab;
    @FindBy(xpath = " //li[@class =\"  level1\"]/a/span/following::span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(xpath = "//span[text()='This is for test,pls dont delete (0)']")
    WebElement targetRootCategoryLink;
    @FindBy(xpath = "//select[@id='group_4is_active']")
    WebElement isActiveDropDown;
    @FindBy(id = "group_4description")
    WebElement descriptionField;
    @FindBy(id = "group_4meta_keywords")
    WebElement metaKeywordsField;
    @FindBy(css = "textarea#group_4meta_description")
    WebElement metaDescriptionField;
    @FindBy(xpath = "//button[@title=\"Save Category\"]/span/span/span[text()='Save Category']")
    WebElement saveEditedRootCategoryButton;
    @FindBy(xpath = "//li[@class=\"success-msg\"]/ul/li/span[text()='The category has been saved.']")
    WebElement VerifyMessageRootCategoryEdited;

    public EditRootCategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
        actions = new Actions(driver);
        faker = new Faker();
    }

    public void editTargetRootCategory() {
        functionLibrary.waitElemantPresent(catalogTab);
        catalogTab.click();
        functionLibrary.waitElemantPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionLibrary.waitElemantPresent(targetRootCategoryLink);
        actions.moveToElement(targetRootCategoryLink).click().build().perform();

        functionLibrary.waitElemantPresent(isActiveDropDown);
        Select select1 = new Select(isActiveDropDown);
        select1.selectByValue("1");

       functionLibrary.waitElemantPresent(descriptionField);
        actions.click(descriptionField).sendKeys(faker.name().firstName());

        functionLibrary.waitElemantPresent(metaKeywordsField);
        actions.click(metaKeywordsField).sendKeys(faker.name().lastName());

        functionLibrary.waitElemantPresent(metaDescriptionField);
        metaDescriptionField.sendKeys(faker.name().lastName());

        functionLibrary.waitElemantPresent(saveEditedRootCategoryButton);
        actions.click(saveEditedRootCategoryButton).build().perform();



    }
    public boolean verifyMessageRootCategoryEdited() {
       functionLibrary.waitElemantPresent(VerifyMessageRootCategoryEdited);
        if (VerifyMessageRootCategoryEdited.isDisplayed()) {
            return true;
        } else{
            System.out.println("Root Category Edited Unsuccessfully");
            return false;

        }
    }
}






