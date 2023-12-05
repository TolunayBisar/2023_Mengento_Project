package basefunc;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author : Anargul
 * @created : 11/30/2023,9:47 PM
 * @Email : abdanna369@gmail.com
 **/
public class ScreenShoutUtility {
    public void takeScreenshot(String folder, String fileName, WebDriver driver) {
        DateTime dt1 = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timestamp = dt1.toString(formatter);
        fileName = fileName + "-" + timestamp;
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(imageFile, new File(folder + File.separator + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
