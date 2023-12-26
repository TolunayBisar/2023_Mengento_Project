package com.seleniummaster.ecommercetest.regressiontest.cucumber;

import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.seleniummaster.ecommercetest.api.Payloads;
import org.junit.Assert;

import static com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary.readFromConfig;

public class ApiStepDef {
    Response response;
    @Given("an authorized user with valid API")
    public void an_authorized_user_with_valid_api() {
        RestAssured.baseURI=readFromConfig("api_host");
        RestAssured.port=Integer.parseInt(readFromConfig("api_port"));
        RestAssured.authentication=RestAssured.basic(readFromConfig("api_username"),
                readFromConfig("api_password"));
    }
    @When("the user sends a POST request to create a new product")
    public void the_user_sends_a_post_request_to_create_a_new_product() {
        response =RestAssured.given().contentType(ContentType.JSON).and().
                body(Payloads.productPayload("team3sku"+ FunctionLibrary.randomText())).when().
                post("/product").then().extract().response();
        response.prettyPrint();
    }
    @Then("Response must be with a {} status code")
    public void response_must_be_with_a_status_code(int code) {
        Assert.assertEquals(String.format("Expected status code %d, but got %d",code,
                response.getStatusCode()),code,response.getStatusCode());
    }
    @When("the user sends a GET request to retrieve category {} info")
    public void the_user_sends_a_get_request_to_retrieve_category_info(int categoryId) {
        response= RestAssured.given().when().get("/category/"+categoryId);
        response.prettyPrint();
    }





    @When("the user sends a PUT request to update Customer Group {} info")
    public void theUserSendsAPUTRequestToUpdateCustomerGroupInfo(int customerGroupId) {
        response=RestAssured.given().contentType(ContentType.JSON).and().
                body(Payloads.customerGroupPayload("team3Group"+FunctionLibrary.randomText())).when().
                put("/customergroup/"+customerGroupId).then().extract().response();


    }

    @When("the user sends a PUT request to update customer {} info")
    public void theUserSendsAPUTRequestToUpdateCustomerInfo(int id) {

        String value = "team3"+FunctionLibrary.randomText();
        int attributeId =12;
        int entityId =26;

        response=RestAssured.given().contentType(ContentType.JSON).and().
                body(Payloads.customerPayload(id,attributeId,
                        entityId,value)).when().
                put("/customer").then().extract().response();
    }

    @And("the response must return correct with category name {}")
    public void theResponseMustReturnCorrectWithCategoryNameCategoryValue( String categoryValue) {
        String cateName= response.jsonPath().getString("content[0]");
        Assert.assertTrue(cateName.contains(categoryValue));

    }
}
