package com.seleniummaster.ecommercetest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,10:17
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewlyAddedCreditMemo {
    public boolean verifySQLNewlyAddedCreditMemo(Connection connection, String orderID)  {
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
        String sqlScriptForNewlyAddedCreditMemos = String.format("select * from mg_sales_flat_creditmemo_grid where order_increment_id='%s'",orderID);
        try {
            resultSet=statement.executeQuery(sqlScriptForNewlyAddedCreditMemos);
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
                    int invoiceId = cachedRowSet.getInt("invoice_id");
                    String billingName = cachedRowSet.getString("billing_name");
                    System.out.println("invoice_id: " + invoiceId + " billing_name: " + billingName);
                    rowCount=cachedRowSet.getRow();

                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
                if (rowCount>=1) {
                    isAdded= true;
                    System.out.println("New Credit Memo Rule is added");
                }
            }

        }
        return isAdded;
    }



}


