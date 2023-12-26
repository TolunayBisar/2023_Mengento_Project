package com.seleniummaster.ecommercetest.frontend_page;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener  implements ITestListener {

    static List<ITestNGMethod> passedTest=new ArrayList<>();
    static List<ITestNGMethod> failedTest=new ArrayList<>();
    static List<ITestNGMethod> skippedTest=new ArrayList<>();

    ScreenShootUtilities screenShootUtilities=new ScreenShootUtilities();





    public void onTestSuccess(ITestResult result) {
        passedTest.add(result.getMethod());
        System.out.println("Test passed...."+passedTest.toString());
        screenShootUtilities.takeScreenShot(result.getMethod().getMethodName().trim()+"Passed",
                (WebDriver)result.getTestContext().getAttribute("driver"));

    }

    public void onTestFailure(ITestResult result) {
        failedTest.add(result.getMethod());
        System.out.println("Test Failed...."+failedTest.toString());
        screenShootUtilities.takeScreenShot(result.getMethod().getMethodName().trim()+"failed",
                (WebDriver)result.getTestContext().getAttribute("driver"));
    }

    public void onTestSkipped(ITestResult result) {
        skippedTest.add(result.getMethod());
    }



}




