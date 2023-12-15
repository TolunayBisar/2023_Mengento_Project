package backend.catalogmodule;

import basefunc.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductsCatalog {
        public WebDriver driver;
        FunctionLibrary functionLibrary;
        Select select;
        @FindBy(xpath = "//tr//button[@title=\"Add Product\"]")
        WebElement addProductButton;
        @FindBy(xpath = "//select[@id=\"attribute_set_id\"]")
        WebElement attributeSetField;
        @FindBy(xpath = "//span[text()=\"Continue\"]")
        WebElement continueButton;
        @FindBy(id = "name")
        WebElement nameField;
        @FindBy(xpath = "//textarea[@id=\"description\"]")
        WebElement descriptionField;
        @FindBy(xpath = "//textarea[@id=\"short_description\"]")
        WebElement shortDescriptionField;
        @FindBy(xpath = "//input[@id=\"sku\"]")
        WebElement skuField;
        @FindBy(xpath = "//input[@id=\"weight\"]")
        WebElement weightField;
        @FindBy(xpath = "//select[@id=\"status\"]")
        WebElement statusField;
        @FindBy(xpath = "//select//option[text()=\"Enabled\"]")
        WebElement listEnabled;
        @FindBy(xpath = "//select[@id=\"visibility\"]")
        WebElement visibilityField;
        @FindBy(xpath = "//span[text()=\"Save\"]")
        WebElement saveButton;
        @FindBy(xpath = "//input[@id=\"price\"]")
        WebElement priceField;
        @FindBy(xpath = "//select[@id=\"tax_class_id\"]")
        WebElement taxClassField;
        @FindBy(xpath = "//span[text()=\"The product has been saved.\"]")
        WebElement successMessage;

        public AddProductsCatalog(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
            functionLibrary=new FunctionLibrary(driver);
        }

        public void addProduct(){
            functionLibrary.waitElemantPresent(addProductButton);
            addProductButton.click();
            functionLibrary.waitElemantPresent(attributeSetField);
            attributeSetField.click();
            select = new Select(attributeSetField);
            select.selectByVisibleText("Books & Music");
            continueButton.click();
            functionLibrary.waitElemantPresent(nameField);
            nameField.sendKeys(functionLibrary.generateFakeName1()+"Team3");
            functionLibrary.waitElemantPresent(descriptionField);
            descriptionField.sendKeys(functionLibrary.generateFakerDescription());
            functionLibrary.waitElemantPresent(shortDescriptionField);
            shortDescriptionField.sendKeys(functionLibrary.generateFakerDescription());
            functionLibrary.waitElemantPresent(skuField);
            skuField.sendKeys(functionLibrary.generateFakerSKU()+functionLibrary.timeStamp());
            functionLibrary.waitElemantPresent(weightField);
            weightField.sendKeys(functionLibrary.generateFakerWeight());
            select=new Select(statusField);
            select.selectByVisibleText("Enabled");
            select=new Select(visibilityField);
            select.selectByVisibleText("Catalog, Search");
            functionLibrary.javaScripClick(saveButton);
            functionLibrary.waitElemantPresent(priceField);
            priceField.sendKeys(functionLibrary.generateFakerPrice());
            select=new Select(taxClassField);
            select.selectByVisibleText("Shipping");
            functionLibrary.javaScripClick(saveButton);

        }

        public boolean verifyAddedProductOnCatalogPage(){
            functionLibrary.waitElemantPresent(successMessage);
            if (successMessage.isDisplayed()){
                System.out.println("The product successfully added");
            }
            return true;

        }


}
