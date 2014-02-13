package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> items;
    
    public Menu(){
        items = new ArrayList<MenuItem>();
    }
    
    public void addItem(MenuItem item)throws IllegalArgumentException{
        if(item!=null){
            items.add(item);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }
    
    public MenuItem getItem(int itemId){
        return items.get(itemId);
    }
    
    public MenuItem getItem(String itemName){
        MenuItem item = null;
        for(MenuItem i: items){
            if(itemName.equals(i.getName())){
                item = i;
            }
        }
        return item;
    }
    
    public String toString(){
        String menuString = "";
        for(int i=0; i<items.size(); i++){
            String item = items.get(i).toString();
            menuString+=item + "<br>";
        }
        return menuString;
    }
}
