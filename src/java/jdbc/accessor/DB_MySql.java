package jdbc.accessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_MySql implements DBAccessor{
    private final String username;
    private final String password;
    private final String url;
    private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private Connection c;

    public DB_MySql(String username, String password, String url){
        this.username=username;
        this.password=password;
        this.url=url;
    }
    
    @Override
    public void openConnection(String username, String password, String url)
            throws IllegalArgumentException, SQLException, ClassNotFoundException {
        
        Class.forName(DRIVER_CLASS_NAME);
        c = DriverManager.getConnection(url, username, password);
    }

    @Override
    public List<Map> findRecord(String sql, boolean close) 
            throws SQLException, IllegalArgumentException, ClassNotFoundException {
        final int MAX_RECORDS = 6;
        
        openConnection(username, password, url);
        
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Map> results = new ArrayList<Map>();
        
        while(rs.next()){
            Map map = new HashMap();
            map.put("menu_id", rs.getInt(1));
            map.put("item_name", rs.getString(2));
            map.put("item_price", rs.getDouble(3));
            results.add(map);
        }
        
        if(close){
            closeConnection();
        }
        
        return results;
    }

    @Override
    public void closeConnection() throws SQLException {
        c.close();
    }
}
