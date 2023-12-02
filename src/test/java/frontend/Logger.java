package frontend;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author : Anargul
 * @created : 11/30/2023,9:38 PM
 * @Email : abdanna369@gmail.com
 **/
public class Logger {
    private  static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class.getName());

    public Logger() {
        DOMConfigurator.configure("C:\\Users\\abdan\\IdeaProjects\\SDET2023Magento_Team3\\log4j2.xml");
    }

    public static void info(String massage) {
        logger.info(massage);
    }

    public static void warn(String massage) {
        logger.warn(massage);
    }

    public static void error(String massage) {
        logger.error(massage);
    }

    public static void debug(String massage) {
        logger.debug(massage);
    }
}
