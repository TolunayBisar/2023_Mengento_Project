package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : Anargul
 * @created : 12/2/2023,9:57 AM
 * @Email : abdanna369@gmail.com
 **/
public class ViewOrderAsRegistredUser extends BaseClass {
    WebDriver driver ;
    FunctionLibrary functionLibrary;
    @FindBy(xpath= "//div[@class=\"box-head\"]/h2[text()=\"Recent Orders\"]")
    WebElement ViewOrderLink;

    public ViewOrderAsRegistredUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public boolean registredUserViewOrder() {
        Boolean viewOrder = false;
        if (ViewOrderLink.isDisplayed()){
            System.out.println("Orders successfully Added.");
        viewOrder = true;
        }
     if (!ViewOrderLink.isDisplayed()){
                System.out.println("Please add product again");
}
        return viewOrder;
    }
}