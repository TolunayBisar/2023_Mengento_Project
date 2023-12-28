package com.seleniummaster.ecommercetest.regressiontest.cucumber;

import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : tolunaybisar
 * @created : 27.12.2023,00:57
 * @Email :tolunay.bisar@gmail.com
 **/

    @RunWith(Cucumber.class)
    @CucumberOptions(

            features = "classpath:features/customer-module.feature",


            plugin ={
                    "pretty",
                    "html:target/cucumber-html-report.html",
                    "json:target/cucumber-json-report.json",
                    "junit:target/cucumber-xml-report.xml "
            },



            tags = "")




    public class CucumberCustomerModuleTestRunner {




    }

