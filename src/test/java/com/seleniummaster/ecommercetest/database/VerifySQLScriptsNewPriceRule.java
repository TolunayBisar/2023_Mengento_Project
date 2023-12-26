package com.seleniummaster.ecommercetest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifySQLScriptsNewPriceRule {
    public boolean getNewAddedPriceRule(Connection connection, String newPriceRule)  {
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
        String sqlScriptForNewPriceRule = String.format("select rule_id,name from mg_salesrule where name='%s'",newPriceRule);
        try {
            resultSet=statement.executeQuery(sqlScriptForNewPriceRule);
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
                    int rule_id = cachedRowSet.getInt("rule_id");
                    String name = cachedRowSet.getString("name");
                    System.out.println("rule_id: " + rule_id + " name: " + name);
                    rowCount=cachedRowSet.getRow();

                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
                if (rowCount>=1) {
                    isAdded= true;
                    System.out.println("New Price Rule is added");
                }
            }

        }
        return isAdded;
    }



}
