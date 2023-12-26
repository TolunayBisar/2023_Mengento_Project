package magentodatabase;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : tolunaybisar
 * @created : 26.12.2023,19:40
 * @Email :tolunay.bisar@gmail.com
 **/
public class VerifySQLNewlyAddedStore {
    public boolean verifySQLNewlyAddedStore(Connection connection, String storeName) {
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
        String sqlScriptForNewStoreAdded = String.format("select store_id , name, is_active  from mg_core_store where name='%s'", storeName);
        try {
            resultSet = statement.executeQuery(sqlScriptForNewStoreAdded);
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
                    String store_id = cachedRowSet.getString("store_id");
                    int is_active = cachedRowSet.getInt("is_active");
                    String storeName1 = cachedRowSet.getString("name");
                    System.out.println(" is_active: " + is_active +"\n" + "store_id: " + store_id +"\n"+ "name: "
                            +storeName1+"\n");
                    rowCount = cachedRowSet.getRow();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (rowCount >= 1) {
                    isAdded = true;
                    System.out.println("New Store is added");
                }
            }

        }
        return isAdded;
    }
}
