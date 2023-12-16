package regressiontest.apitest;

import basefunc.ApplicationConfig;
import basefunc.FunctionLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import magentoapi.Payloads;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,19:32
 * @Email :tolunay.bisar@gmail.com
 **/
public class APTest {

    private int categoryID;
    private int customerGroupID;
    private String categoryValue1 ;
    private String groupName ;
    private int customerID ;
    private String customerName ;
    private int attributeId;
    private int entityId;
    private String sku ;


    @BeforeClass
    public void setUp() {
        String cfFile = "config.properties";
        RestAssured.baseURI = ApplicationConfig.readFromConfig(cfFile, "api_host");

        RestAssured.port = Integer.parseInt(ApplicationConfig.readFromConfig(cfFile, "api_port"));
        RestAssured.authentication = RestAssured.basic(ApplicationConfig.readFromConfig
                (cfFile, "api_username"), ApplicationConfig.readFromConfig(cfFile, "api_password"));


    }

    @Test(description = "as a Admin user should be able to get category  By ID ", priority = 1)
    public void getCategoryById() {
        categoryID =1;
        categoryValue1= "cbus";
        Response response = RestAssured.given().pathParams("id", categoryID).when().get("/category/{id}");
        response.getBody().prettyPrint();
        assert response.getStatusCode() == 200 : "Expected status code 200,but got :" + response.getStatusCode();
        String categoryValue = response.jsonPath().getString("value");

        assert response.headers().getValue("X-Frame-Options").equals("DENY") : "Header doesn't have the right ley or value";
    }

    @Test(description = "as a Admin user should be able to update CustomerGroup ", priority = 2)
    public void putCustomerGroup() {
        customerGroupID=0;
        groupName= "Team3-CustomerGroup"+FunctionLibrary.randomText();
        RestAssured.given().pathParams("id", customerGroupID).contentType(ContentType.JSON).
                and().body(Payloads.customerGroupPayload(groupName)).when().put("/customergroup/{id}").
                then().assertThat().statusCode(204).extract().response();
    }

    @Test(description = "as a Admin user should be able to update customer  ", priority = 3)
    public void putCustomer() {
        customerID= 341;
        customerName= "Team3-Customer"+FunctionLibrary.randomText();
        attributeId = 12;
        entityId=26;
        RestAssured.given().contentType(ContentType.JSON).
                and().body(Payloads.customerPayload(customerID,attributeId,entityId,
                        customerName)).when().put("/customer").
                then().assertThat().statusCode(200).extract().response();
    }

    @Test(description = "as a Admin user should be able to add product ", priority = 4)
    public void postSomeProductTest() {
        sku = "team3"+FunctionLibrary.randomText();
        Response response = RestAssured.given().header("Content-Type", "application/json").and().
                body(Payloads.productPayload(sku)).
                when().post("/product").then().extract().response();
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);


    }

}
