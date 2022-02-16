/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author b1086175
 */
public class Order {
    private File path;
    private ArrayList<Item> items;

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

    public ArrayList<Item> getItems() {
        return items;
    }
    
    
    
    public int size() {
        return items.size();
    }
}
