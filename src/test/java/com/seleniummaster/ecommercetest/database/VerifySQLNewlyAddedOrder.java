package com.seleniummaster.ecommercetest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,19:13
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewlyAddedOrder {
    public boolean verifySQLNewlyAddedOrder(Connection connection, String orderNo) {
        boolean isAdded = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForNewOrderAdded = String.format("select customer_email , customer_lastname, entity_id, increment_id  from mg_sales_flat_order where increment_id='%s'", orderNo);
        try {
            resultSet = statement.executeQuery(sqlScriptForNewOrderAdded);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("No records found");
            return isAdded;

        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            while (true) {

                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    String increment_id = cachedRowSet.getString("increment_id");
                    int entity_id = cachedRowSet.getInt("entity_id");
                    String customer_email = cachedRowSet.getString("customer_email");
                    String customer_lastname = cachedRowSet.getString("customer_lastname");
                    System.out.println(" entity_id: " + entity_id +"\n" + "increment_id: " + increment_id +"\n"+ "customer_email: "
                    +customer_email+"\n"+ "customer_lastname: "+ customer_lastname);
                    rowCount = cachedRowSet.getRow();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (rowCount >= 1) {
                    isAdded = true;
                    System.out.println("New Order is added");
                }
            }

        }
        return isAdded;
    }
}
