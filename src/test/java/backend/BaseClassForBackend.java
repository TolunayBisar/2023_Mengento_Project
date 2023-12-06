package backend;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClassForBackend {
    public static WebDriver driver;


    public static void setUpBrowser() {


        ChromeOptions options = new ChromeOptions();

        if (SystemUtils.IS_OS_LINUX){
            options.addArguments("headless");
            options.addArguments("window-size=1200,1080");
            options.addArguments("disable-gpu");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        if (SystemUtils.IS_OS_MAC_OSX||SystemUtils.IS_OS_WINDOWS) {
            driver.manage().window().maximize();
        }


        driver.get("https://ecommerce.unitedcoderapp.com/index.php/admin");
    }

    public  static void closeBrowser(){
        driver.close();
        driver.quit();

    }

}
