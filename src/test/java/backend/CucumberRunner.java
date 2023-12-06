package backend;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-json-report.json",
                "junit:target/cucumber-xml-report.xml"},
        features ="classpath:features/customer-module.feature",
        tags = "@CustomerModule"
)

public class CucumberRunner extends BaseClassForBackend {
   @BeforeClass
    public static void setUp(){
       setUpBrowser();
    }
    @AfterClass
    public static void tearDown(){
        closeBrowser();
    }
}
