package basefunc;

/**
 * @author : tolunaybisar
 * @created : 27.11.2023,17:57
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginDataForBackEnd {
    private final String url_backend = FunctionLibrary.readFromConfig("BackEnd_url");
    private final String username_customer_manager = FunctionLibrary.readFromConfig("username_customermanager");
    private final String username_catalog_manager = FunctionLibrary.readFromConfig("username_catalogmanager");
    private final String username_marketing_manager = FunctionLibrary.readFromConfig("username_marketingmanager");
    private final String username_sales_manager = FunctionLibrary.readFromConfig("username_salesmanager");
    private final String username_store_manager = FunctionLibrary.readFromConfig("username_storemanager");
    private final String username_reporting_manager = FunctionLibrary.readFromConfig("username_reportingmanager");
    private final String password = FunctionLibrary.readFromConfig("password");




    public String getUrlBackend() {
        return url_backend;
    }

    public String getUsernameCustomerManager() {
        return username_customer_manager;
    }

    public String getUsernameCatalogManager() {
        return username_catalog_manager;
    }

    public String getPassword() {
        return password;
    }

    public String getUsernameMarketingManager() {
        return username_marketing_manager;
    }
    public String getUsernameSalesManager() {
        return username_sales_manager;
    }

    public String getUsernameStoreManager() {
        return username_store_manager;
    }

    public String getUsernameReportingManager() {
        return username_reporting_manager;
    }

}
