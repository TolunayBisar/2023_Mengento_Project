package com.seleniummaster.ecommercetest.basefunction_page;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,18:16
 * @Email :tolunay.bisar@gmail.com
 **/
public class ApplicationConfig {
    public static String readFromConfig(String fileName,String key){
        Properties properties=new Properties();
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value=properties.getProperty(key);
        return value;
    }

    /**
     * @author : Anargul
     * @created : 11/30/2023,9:39 PM
     * @Email : abdanna369@gmail.com
     **/
    public static class TestResultListener implements ITestListener {
        Logger logger = new Logger();

        @Override
        public void onTestStart(ITestResult result) {
            ITestListener.super.onTestStart(result);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            ITestListener.super.onTestSuccess(result);
            String testName = result.getTestName();
            logger.info("PASSED");

        }

        @Override
        public void onTestFailure(ITestResult result) {
            ITestListener.super.onTestFailure(result);
            String testFailCause = result.getTestName();
            logger.error( "FAILD whith caous ");
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            ITestListener.super.onTestFailedWithTimeout(result);
        }

        @Override
        public void onStart(ITestContext context) {
            ITestListener.super.onStart(context);
        }

        @Override
        public void onFinish(ITestContext context) {
            ITestListener.super.onFinish(context);
        }

    }
}
