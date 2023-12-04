package frontend;

import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunTest extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd;
    ViewMyProductReviewsPage viewMyProductReviewsPage;
    @BeforeClass
    public void setUp() {
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
        viewMyProductReviewsPage = new ViewMyProductReviewsPage(driver);

    }
    @Test
    public void reviews(){
        viewMyProductReviewsPage.myProductsReviewLinkAndViewDetails();
        viewMyProductReviewsPage.myProductReviewDetails();
        Assert.assertTrue(viewMyProductReviewsPage.verifyReviewDetails());

    }

    }



