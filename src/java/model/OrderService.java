package model;

import java.sql.SQLException;

public class OrderService {
    private MenuDAO mdao = new MenuDAO();
    private Menu menu;
    private Menu ordered;
    
    public OrderService() throws SQLException, ClassNotFoundException{
        menu = getMenu();
        ordered = new Menu();
    }
    
    public Menu getMenu() throws SQLException, ClassNotFoundException{
        return mdao.getMenu();
    }
    
    public void addToOrder(MenuItem itemOrdered){
        ordered.addItem(itemOrdered);
    }
    
    public Menu getOrder(){
        return ordered;
    }
}