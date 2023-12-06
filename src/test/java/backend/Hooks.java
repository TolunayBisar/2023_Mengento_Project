package backend;

import basefunc.BaseClassForBackend;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClassForBackend {
    @Before
    public void setup(Scenario scenario) {
        if(scenario.getSourceTagNames().contains("@UiTest")) {
            scenario.log("Begin with UI Automation Test");
            setUpBrowser();
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

