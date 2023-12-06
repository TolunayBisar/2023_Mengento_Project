package backend;

import basefunc.BaseClassForBackend;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
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
        tags = "@CatalogModule")

public class CucumberTestRunner extends BaseClassForBackend {
//    @BeforeClass
//        public static void setup(){
//                setUpBrowser();
//        }
//        @AfterClass
//        public static void teardown(){
//                closeBrowser();
//        }
}
