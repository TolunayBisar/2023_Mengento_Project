package com.seleniummaster.ecommercetest.regressiontest.cucumber.stepdefinations;


import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;


import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.backend_page.catalogmodule.*;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogModuleStepdefs extends BaseClass {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    SearchTermsPage searchTermsPage = new SearchTermsPage(driver);
    EditRootCategory editRootCategory = new EditRootCategory(driver);

    FilterSearchTermsPage filterSearchTermsPage = new FilterSearchTermsPage(driver);

    EditSearchTerms editSearchTerms = new EditSearchTerms(driver);
    AddProductsCatalog addProductsCatalog = new AddProductsCatalog(driver);

    @Given("Catalog manager on the dashboard page")
    public void catalogManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager()
                , loginDataForBackEnd.getPassword());
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


    /**
     * @author sherzat
     */
    @When("catalog manager filter search terms by SearchQuery")
    public void catalogManagerFilterSearchTermsBySearchQuery() {
        filterSearchTermsPage.filterBySearchQuery("shirt");
    }

    @When("catalog manager filter search terms by Store")
    public void catalogManagerFilterSearchTermsByStore() {
        filterSearchTermsPage.filterByStore();
    }

    @When("catalog manager filter search terms by Result")
    public void catalogManagerFilterSearchTermsByResult() {
        filterSearchTermsPage.filterByResult("0", "9");
    }

    @When("catalog manager filter search terms by Use")
    public void catalogManagerFilterSearchTermsByUse() {
        filterSearchTermsPage.filterByUse("0", "9");
    }

    @When("catalog manager filter search terms by Synonym")
    public void catalogManagerFilterSearchTermsBySynonym() {
        filterSearchTermsPage.filterBySynonym("a");
    }

    @When("catalog manager filter search terms by Suggested Terms")
    public void catalogManagerFilterSearchTermsBySuggestedTerms() {
        filterSearchTermsPage.filterBySuggestedTerms();
    }

    @Then("filter result should be display on the page")
    public void filterResultShouldBeDisplayOnThePage() {
        filterSearchTermsPage.verifyFilter();


    }

    @When("catalog Manager edit existing search terms")
    public void catalogManagerEditExistingSearchTerms() {
    }

    @Then("existing search terms should be successfully edited")
    public void existingSearchTermsShouldBeSuccessfullyEdited() {
    }


    @When("Catalog manager added product")
    public void catalogManagerAddedProduct() {
        addProductsCatalog.addProduct();
    }

    @Then("product should be successfully added and success message should be displayed")
    public void productShouldBeSuccessfullyAddedAndSuccessMessageShouldBeDisplayed() {
        addProductsCatalog.verifyAddedProductOnCatalogPage();
    }
}
