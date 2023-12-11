package backend;

<<<<<<< HEAD
import basefunc.ApplicationConfig;
=======
import basefunc.BaseClass;
>>>>>>> 38d0951a495fd070249e39c6abd19933ac159749
import basefunc.BaseClassForBackend;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/catalog-module.feature",
        plugin ={
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-json-report.json",
                "junit:target/cucumber-xml-report.xml "
        },
<<<<<<< HEAD
        tags = "@FilterSearchTerms")

public class CucumberTestRunner extends BaseClassForBackend {
   @Before
        public static void setup(){
                setUpBrowser(ApplicationConfig.readFromConfig("config.properties","BackEnd_url"));
        }
       @After
       public static void teardown(){
              closeBrowser();
        }
=======

        tags = "")



public class CucumberTestRunner extends BaseClass {


//   @Before
//        public static void setup(){
//                setUpBrowser();
//        }
//       @After
//       public static void teardown(){
//              closeBrowser();
//        }
>>>>>>> 38d0951a495fd070249e39c6abd19933ac159749
}
