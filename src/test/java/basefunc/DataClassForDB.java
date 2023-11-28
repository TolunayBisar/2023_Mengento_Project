package basefunc;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:54
 * @Email :tolunay.bisar@gmail.com
 **/
public class DataClassForDB {


    private final String url = FunctionLibray.readFromConfig("dburl");
    private final String port = FunctionLibray.readFromConfig("dbport");
    private final String username = FunctionLibray.readFromConfig("dbusername");
    private final String password = FunctionLibray.readFromConfig("dbpassword");
    private final String defaultDB = FunctionLibray.readFromConfig("dbname");



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


