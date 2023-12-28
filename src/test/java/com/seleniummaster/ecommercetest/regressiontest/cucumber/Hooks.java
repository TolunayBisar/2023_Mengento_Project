package com.seleniummaster.ecommercetest.regressiontest.cucumber;


import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import io.cucumber.java.*;

public class Hooks extends BaseClass {
    @Before
    public  void setup(Scenario scenario) {
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
    public  void teardown(Scenario scenario){
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

