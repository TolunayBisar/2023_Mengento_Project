package com.seleniummaster.ecommercetest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,18:03
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewAddedCustomerGroup {
    public boolean verifySQLNewlyAddedCreditMemo(Connection connection, String customerGroupName)  {
        boolean isAdded = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForNewCustomerGroupAdded = String.format("select customer_group_id, customer_group_code from mg_customer_group where customer_group_code='%s'",customerGroupName);
        try {
            resultSet=statement.executeQuery(sqlScriptForNewCustomerGroupAdded);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet==null){
            System.out.println("No records found");
            return isAdded;

        }
        else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            while (true){

                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try{
                    int customerGroupId = cachedRowSet.getInt("customer_group_id");
                    String customerGroupName1 = cachedRowSet.getString("customer_group_code");
                    System.out.println("customer_group_id: " + customerGroupId + " customer_group_code: " + customerGroupName1);
                    rowCount=cachedRowSet.getRow();

                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
                if (rowCount>=1) {
                    isAdded= true;
                    System.out.println("New Customer Group Rule is added");
                }
            }

        }
        return isAdded;
    }

}
