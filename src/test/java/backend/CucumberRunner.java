package backend;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin ={
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-json-report.json",
                "junit:target/cucumber-xml-report.xml "
        },
        tags = "@CustomerModule")

public class CucumberRunner extends BaseClassForBackend{
//    @BeforeClass
//        public static void setup(){
//                setUpBrowser();
//        }
//        @AfterClass
//        public static void teardown(){
//                closeBrowser();
//        }
}
