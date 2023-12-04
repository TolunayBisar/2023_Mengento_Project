package basefunc;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:52
 * @Email :tolunay.bisar@gmail.com
 **/
public class BaseClass {
    public WebDriver driver;
    public void setUpBrowser(String url) {
        ChromeOptions options = new ChromeOptions();

        if (SystemUtils.IS_OS_LINUX){
            options.addArguments("headless");
            options.addArguments("window-size=1200,1080");
            options.addArguments("disable-gpu");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        if (SystemUtils.IS_OS_MAC_OSX||SystemUtils.IS_OS_WINDOWS) {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        driver.get(url);
    }
    public static void openBrowser(){
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://ecommerce.unitedcoderapp.com/");
        driver.manage().window().maximize();

    }

    public  void closeBrowser(){
        driver.close();
        driver.quit();

    }
}



