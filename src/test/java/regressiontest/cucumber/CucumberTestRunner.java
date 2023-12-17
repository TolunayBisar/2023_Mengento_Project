package regressiontest.cucumber;



import basefunc.BaseClass;
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



        tags = "@AddProduct")




public class CucumberTestRunner  {

}





