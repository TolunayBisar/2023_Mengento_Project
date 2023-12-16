package regressiontest.cucumber;


import backend.customersmodule.AddCustomer;
import backend.customersmodule.AssignCustomerToGroup;
import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
    @Before
    public void setup(Scenario scenario) {
        if(scenario.getSourceTagNames().contains("@UiTest")) {
            scenario.log("Begin with UI Automation Test");

            setUpBrowser(ApplicationConfig.readFromConfig("config.properties","BackEnd_url"));
        }else if(scenario.getSourceTagNames().contains("@DatabaseTest")){
            scenario.log("Begin with Database Automation Test");
        }else {
            scenario.log("Begin with API Test Automation");
        }
    }



    @After
    public void teardown(Scenario scenario){
        if(scenario.getSourceTagNames().contains("@UiTest")) {
            scenario.log("End with UI Automation Test");
            closeBrowser();
        }else if(scenario.getSourceTagNames().contains("@DatabaseTest")){
            scenario.log("End with Database Automation Test");
        }else {
            scenario.log("End with API Test Automation");
        }
    }
}

