package backend.catalogmodule;

import basefunc.FunctionLibray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewSearchTerm {
    WebDriver driver;
    FunctionLibray functionLibray;

    public AddNewSearchTerm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibray = new FunctionLibray(driver);
    }
}
