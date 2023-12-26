package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShootUtilities extends BaseClass {


    public void takeScreenShot(String fileName, WebDriver driver){

        if (driver == null) {
            System.out.println("Driver is null. Cannot take screenshot.");
            return;
        }
        DateTime dateTime=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm");
        String timeStamp=dateTime.toString(formatter);
        fileName=fileName+"_"+timeStamp;
        File imageFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (imageFile == null) {
            System.out.println("Image folder is null. Cannot save screenshot.");
            return;
        }
        String imageFolder= ApplicationConfig.readFromConfig("config.properties","imageFolder");
        try {
            FileUtils.copyFile(imageFile,new File(imageFolder+File.separator+fileName+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
