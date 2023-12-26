package com.seleniummaster.ecommercetest.basefunction_page;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:54
 * @Email :tolunay.bisar@gmail.com
 **/
public class DataClassForDB {


    private final String url = FunctionLibrary.readFromConfig("dburl");
    private final String port = FunctionLibrary.readFromConfig("dbport");
    private final String username = FunctionLibrary.readFromConfig("dbusername");
    private final String password = FunctionLibrary.readFromConfig("dbpassword");
    private final String defaultDB = FunctionLibrary.readFromConfig("dbname");



    public String getUrl() {
        return url;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDefaultDB() {
        return defaultDB;
    }
}


