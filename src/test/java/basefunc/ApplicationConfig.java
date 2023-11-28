package basefunc;

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

}
