package com.seleniummaster.ecommercetest.regressiontest.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : tolunaybisar
 * @created : 27.12.2023,00:44
 * @Email :tolunay.bisar@gmail.com
 **/

    @RunWith(Cucumber.class)
    @CucumberOptions(

            features = "classpath:features/marketing-module.feature  ",


            plugin ={
                    "pretty",
                    "html:target/cucumber-html-report.html",
                    "json:target/cucumber-json-report.json",
                    "junit:target/cucumber-xml-report.xml "
            },



            tags = "")




    public class CucumberMarketingModuleTestRunner {

    }



