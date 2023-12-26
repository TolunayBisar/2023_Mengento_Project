package magentodatabase;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,19:53
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewlyAddedTaxRule {
    public boolean verifySQLNewlyAddedTaxRule(Connection connection, String taxName) {
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
        String sqlScriptForNewTaxRuleAdded = String.format("select *  from mg_tax_calculation_rule where code='%s'", taxName);
        try {
            resultSet = statement.executeQuery(sqlScriptForNewTaxRuleAdded);
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
                    String tax_calculation_rule_id = cachedRowSet.getString("tax_calculation_rule_id");
                    int priority = cachedRowSet.getInt("priority");
                    String taxCodeName = cachedRowSet.getString("code");
                    System.out.println(" etax_calculation_rule_id: " + tax_calculation_rule_id +"\n" + "priority: " + priority +"\n"+ "taxCodeName: "
                            +taxCodeName+"\n");
                    rowCount = cachedRowSet.getRow();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (rowCount >= 1) {
                    isAdded = true;
                    System.out.println("New Tax Rule is added");
                }
            }

        }
        return isAdded;
    }
}
