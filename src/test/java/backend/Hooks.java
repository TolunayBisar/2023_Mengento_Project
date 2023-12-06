package backend;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClassForBackend {


    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@UiTest")) {
            scenario.log("Begin with UI automation test");
            setUpBrowser();
        } else if (scenario.getSourceTagNames().contains("@DataBaseTest")) {
        scenario.log("Begin with Database automation test");
        } else if (scenario.getSourceTagNames().contains("@ApiTest")){
            scenario.log("Begin with API test automation");
        }
    }
    @After
    public void tearDown(Scenario scenario) {
            if (scenario.getSourceTagNames().contains("@UiTest")){
                scenario.log("End with UI automation test");
                closeBrowser();
            }else if (scenario.getSourceTagNames().contains("@DataBaseTest")){
           scenario.log("End with Database automation test");
            }else if (scenario.getSourceTagNames().contains("@ApiTest")){
                scenario.log("Begin with API test automation");
            }
        }

    }

