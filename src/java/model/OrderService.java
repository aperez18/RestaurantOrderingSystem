package model;

import java.sql.SQLException;

public class OrderService {
    private MenuDAO mdao = new MenuDAO();
    
    public Menu getMenu() throws SQLException, ClassNotFoundException{
        return mdao.getMenu();
    }
    
    public static void main(String[] args){
        OrderService order = new OrderService();
        try{
            System.out.println(order.getMenu().toString());
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
}