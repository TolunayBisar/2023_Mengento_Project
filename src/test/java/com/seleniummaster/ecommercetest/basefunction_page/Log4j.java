package com.seleniummaster.ecommercetest.basefunction_page;

import org.apache.log4j.Logger;


/**
 * @author : Anargul
 * @created : 11/30/2023,9:38 PM
 * @Email : abdanna369@gmail.com
 **/
public class Log4j {
    private static Logger logger = Logger.getLogger(Log4j.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}