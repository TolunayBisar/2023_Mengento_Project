package regressiontest.backendtest;


import backend.catalogmodule.AddProductsCatalog;
import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 13.12.2023,13:12
 * @Email :tolunay.bisar@gmail.com
 **/
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
