package backend.customersmodule;

import basefunc.FunctionLibrary;
import basefunc.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ExportCustomersPage {
    WebDriver driver;
    FunctionLibrary functionLibray;

    public ExportCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibray = new FunctionLibrary(driver);
    }

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customers;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomers;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;

    public void exportCustomers() {
        functionLibray.waitElemantPresent(customers);
        customers.click();
        functionLibray.waitElemantPresent(manageCustomers);
        manageCustomers.click();
        functionLibray.waitElemantPresent(exportButton);
        exportButton.click();
    }

    public boolean verifyFileExist() {
        File folder = new File("C:\\Users\\updete\\IdeaProjects\\SDET2023Magento_Team3\\DownloadableFile");
        File[] listofFiles = folder.listFiles();
        boolean isFileExist = false;
        for (File listofFile : listofFiles) {
            if (listofFile.isFile()) {
                String fileName = listofFile.getName();
                System.out.println("File name is :" + fileName);
                if (fileName.matches("customers.csv")) {
                    isFileExist = true;
                }
            }

        }

        return isFileExist;
    }
}
