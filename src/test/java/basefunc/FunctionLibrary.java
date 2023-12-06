package basefunc;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:53
 * @Email :tolunay.bisar@gmail.com
 **/
public class
FunctionLibrary {

    WebDriver driver;

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;

    }

    public void sleep(int seconds){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public String readFromConfigProperties(String fileName,String key){
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

    public void waitElemantPresent(WebElement element){
        int timeOut = Integer.parseInt(ApplicationConfig.readFromConfig("config.properties","timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String generateFakeName(){
        String fakeName = Faker.instance().name().firstName();
        return fakeName;
    }
    public String generateFakeName1(){
        String fakeName = Faker.instance().name().firstName();
        return fakeName;
    }
    public String generateFakeEmail1(){
        String mail = Faker.instance().internet().emailAddress();
        return mail;
    }
    public static String  generateFakeEmail(){
        String  mail =  Faker.instance().internet().emailAddress();
        return mail;
    }


    public String generateFakeManufacture() {
        String fakeManufacture = Faker.instance().company().name();
        return fakeManufacture;
    }

    public String generateFakeManufactureURL() {
        String fakeManufactureURL = Faker.instance().company().url();
        return fakeManufactureURL;
    }
   public  String storeURL = "http://"+Faker.instance().internet().url();
    public String generateFakerStreet(){
        String fakerStreet=Faker.instance().address().streetName();
        return fakerStreet;
    }
    public String generateFakerCity(){
        String fakerCity=Faker.instance().address().city();
        return fakerCity;
    }
    public String generateFakerZipcode(){
        String fakerZipCode=Faker.instance().address().zipCode();
        return fakerZipCode;
    }



    public static String readFromConfig(String key){
        return  ApplicationConfig.readFromConfig("config.properties",key);
    }

    public static String randomText(){
        String randomText = RandomStringUtils.randomAlphabetic(4);
        return randomText;

    }


    public String timeStamp() {
        long timeStamp = System.currentTimeMillis();
        return (Long.toString(timeStamp).toString().substring(8));
    }



}
