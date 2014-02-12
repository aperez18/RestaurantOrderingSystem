package model;

import jdbc.accessor.DB_MySql;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MenuDAO {
    private DB_MySql db;
    private MenuItem item;
    private Menu menu = new Menu();
    private final String USERNAME = "root";
    private final String PASSWORD = "000452343";
    private final String URL = "jdbc:mysql://localhost:3306/restaurant";
    
    public MenuDAO(){
        db = new DB_MySql(USERNAME, PASSWORD, URL);
    }
    
    public Menu getMenu() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM menu";
        final String MENU_ID = "menu_id";
        final String ITEM_NAME = "item_name";
        final String ITEM_PRICE = "item_price";
        
        List<Map> items = db.findRecord(sql, true);
        for(int i=0; i<items.size(); i++){
            int id = (int)items.get(i).get(MENU_ID);
            String name = items.get(i).get(ITEM_NAME).toString();
            double price = (double)items.get(i).get(ITEM_PRICE);
            item = new MenuItem(id, name, price);
            menu.addItem(item);
        }
        
        return menu;
    }
}