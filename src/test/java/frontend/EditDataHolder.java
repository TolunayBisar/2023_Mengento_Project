package frontend;

import basefunc.FunctionLibray;

public class EditDataHolder {
    public EditDataHolder() {
    }
    private static String userName = "danna.bergnaum@hotmail.com";
    private static String password = "Omer254182958";

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        EditDataHolder.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        EditDataHolder.password = password;
    }

    private static String email=null;


    public static String getEmail() {

        return email;


    }

    public static void setEmail(String email) {
        EditDataHolder.email = email;
    }
}
