package frontend;

import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForFrontEnd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : Anargul
 * @created : 12/6/2023,3:21 PM
 * @Email : abdanna369@gmail.com
 **/
public class RegistredUserViewDownloadbleOrder {
    WebDriver driver;
    FunctionLibrary functionLibray;
    @FindBy (xpath = "//tr[@class=\"first odd\"]")
    WebElement viewOrderInformation;

    public RegistredUserViewDownloadbleOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibrary(driver);
    }
    DashBoardPageForFrontEnd boardPageForFrontEnd;
    public void viewDownladbleOrder() {
        boardPageForFrontEnd.clickOnMyDownloadableProductLink();
    }
    public boolean veriFayeDownloadOrder(){
        boolean DownloadPrdocut = false;
        if (viewOrderInformation.isDisplayed()){
            System.out.println("Admin user view mydownloadble products");
            return true;
        } else if(!viewOrderInformation.isDisplayed()){
            System.out.println("Admin should be download products");
        }return DownloadPrdocut;
    }
}


