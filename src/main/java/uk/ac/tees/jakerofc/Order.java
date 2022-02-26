/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b1086175
 */
public class Order {
    private File path;
    private List<Item> items;

    public Order() {
        path = null;
        items = new ArrayList<Item>();
    }

    public Order(File path) {
        this.path = path;
        items = new ArrayList<Item>();
        
        read();
    }
    
    private void read() {
        
    }
    
    public void addItem(Item itemIn) {
        items.add(itemIn);
    }
    
    public boolean removeItem(int index) {
        if (index < 0 || index >= items.size()) return false;
        
        items.remove(0);
        return true;
    }
    
    public void clear() {
        items.clear();
    }
    
    public Item get(int index) {
        return items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }
    
    public int size() {
        return items.size();
    }
    
    public int calcTotal() {
        int result = 0;
        for (Item e : items) {
            result += e.getItemPrice();
        }
        return result;
    }
    
    private List<Item> sorted() {// broken
        //create a copy of items
        List<Item> sArr = List.copyOf(items);
        
        /*Collections.sort(sArr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getItemPrice() > o2.getItemPrice()) {
                return -1;// left is greater
            }
            if (o1.getItemPrice() < o2.getItemPrice()) {
                return 1;// right is greater
            }
            return 0;// they are equal
            }
            
        });*/
        
        return sArr;
    }
    
    public String orderSummary() {
        String result = "Summary:\n";
        List<Item> myArr = this.sorted();
        
        for (Item e : myArr) {
            result += e.getSummary();
        }
        result += String.format("Order Total: £%.2f", (double)calcTotal() / 100);
        
        return result;
    }
}
