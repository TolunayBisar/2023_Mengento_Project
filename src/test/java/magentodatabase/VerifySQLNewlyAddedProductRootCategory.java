package magentodatabase;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,18:27
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewlyAddedProductRootCategory {
    public boolean verifyNewlyAddedProductRootCategory(Connection connection, String rootCategoryName) {
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
        String sqlScriptForNewRootCategoryAdded = String.format("select entity_id , value from mg_catalog_category_entity_varchar where value='%s'", rootCategoryName);
        try {
            resultSet = statement.executeQuery(sqlScriptForNewRootCategoryAdded);
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
                    String rootCategoryName1 = cachedRowSet.getString("value");
                    int entity_id = cachedRowSet.getInt("entity_id");
                    System.out.println(" entity_id: " + entity_id +"\n" + "Root category Name: " + rootCategoryName1);
                    rowCount = cachedRowSet.getRow();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (rowCount >= 1) {
                    isAdded = true;
                    System.out.println("New Root Category Rule is added");
                }
            }

        }
        return isAdded;
    }
}