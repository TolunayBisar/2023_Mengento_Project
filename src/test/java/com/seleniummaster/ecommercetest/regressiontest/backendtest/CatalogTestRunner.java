package com.seleniummaster.ecommercetest.regressiontest.backendtest;


import com.seleniummaster.ecommercetest.backend_page.catalogmodule.AddProductsCatalog;
import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 13.12.2023,13:12
 * @Email :tolunay.bisar@gmail.com
 **/
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)
public class CatalogTestRunner extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    AddProductsCatalog addProductsCatalog;


    @BeforeClass
    public void setUpBrowser(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);

    }
    @Test(priority = 1)
    public void loginToCatalogPageBackend(){
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager(),
                loginDataForBackEnd.getPassword());
    }
    @Test(priority = 2)
    public void addProductOnCatalogPage(){
        addProductsCatalog=new AddProductsCatalog(driver);
        addProductsCatalog.addProduct();
    }
    @Test(priority = 3)
    public void verifyAddProduct(){
        boolean isAddProductSuccessfully=addProductsCatalog.verifyAddedProductOnCatalogPage();
        Assert.assertTrue(isAddProductSuccessfully,"product added successfully");

    }





    @AfterClass
    public void tearDown(){
        closeBrowser();
    }



}
