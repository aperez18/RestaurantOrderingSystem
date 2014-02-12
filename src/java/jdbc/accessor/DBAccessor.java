package jdbc.accessor;

import java.sql.SQLException;
import java.util.*;

public interface DBAccessor {
    
    public abstract void openConnection(String username, String password, String url)
            throws IllegalArgumentException, SQLException, ClassNotFoundException;
    public abstract List<Map> findRecord(String sql, boolean close) 
            throws SQLException, IllegalArgumentException, ClassNotFoundException;
    public abstract void closeConnection() throws SQLException;
    
}
