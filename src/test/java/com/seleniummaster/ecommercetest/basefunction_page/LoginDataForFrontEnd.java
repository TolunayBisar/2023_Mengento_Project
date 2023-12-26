package com.seleniummaster.ecommercetest.basefunction_page;

/**
 * @author : tolunaybisar
 * @created : 28.11.2023,10:05
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginDataForFrontEnd {

    private final String url_frontend = FunctionLibrary.readFromConfig("FrontEnd_url");
    private final String username_frontend_create = FunctionLibrary.readFromConfig("username_frontend1");
    private final String username_frontend_register = FunctionLibrary.readFromConfig("username_frontend2");
    private final String password_frontend_create = FunctionLibrary.readFromConfig("password_frontend1");
    private final String password_frontend_registered = FunctionLibrary.readFromConfig("password_frontend2");



    public String getUrlFrontEnd() {
        return url_frontend;
    }

    public String getUsernameForLogin() {
        return username_frontend_register;
    }

    public String getUsernameForCreateAccount() {
        return username_frontend_create;
    }

    public String getRegisterPassword() {
        return password_frontend_registered;
    }

    public String getPasswordForCreateAccount() {
        return password_frontend_create;
    }
}
