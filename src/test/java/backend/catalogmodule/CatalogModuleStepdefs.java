package backend.catalogmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    SearchTermsPage searchTermsPage = new SearchTermsPage(driver);
    EditRootCategory editRootCategory = new EditRootCategory(driver);
    @Given("Catalog manager on the dashboard page")
    public void catalogManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyCatologModuleDashboardPage();
    }

    @Given("catalog manager go to the manage catalog page")
    public void catalogManagerGoToTheManageCatalogPage() {
        dashBoardPageForBackEnd.goToSearchTermsPage();
    }

    @When("catalog manager add new search term")
    public void catalogManagerAddNewSearchTerm() {
        searchTermsPage.addNewSearchTerm();
    }

    @Then("add new search term should be displayed")
    public void addNewSearchTermShouldBeDisplayed() {
        searchTermsPage.verifyAddNewSearchTem();
    }

    @When("catalog manager edit root category")
    public void catalogManagerEditRootCategory() {
        editRootCategory.editTargetRootCategory();
    }

    @Then("root category should be edited successfully")
    public void rootCategoryShouldBeEditedSuccessfully() {
        editRootCategory.verifyMessageRootCategoryEdited();
    }
}
