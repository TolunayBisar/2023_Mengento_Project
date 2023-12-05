package basefunc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

import static basefunc.FunctionLibray.readFromConfig;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:52
 * @Email :tolunay.bisar@gmail.com
 **/
public class BaseClass {

    public WebDriver driver;


    public void setUpBrowser(String url) {


        ChromeOptions options = new ChromeOptions();

        if (SystemUtils.IS_OS_LINUX) {
            options.addArguments("headless");
            options.addArguments("window-size=1200,1080");
            options.addArguments("disable-gpu");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        if (SystemUtils.IS_OS_MAC_OSX || SystemUtils.IS_OS_WINDOWS) {
            driver.manage().window().maximize();
        }


        driver.get(url);
    }


    public void closeBrowser() {
        driver.close();
        driver.quit();

    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}






