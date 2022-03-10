/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b1086175
 */
public class Order {
    private static Order myOrder;
    
    private File path;
    private List<Item> items;

    private Order() {
        path = null;
        items = new ArrayList<Item>();
    }
    
    public static Order getInstance() {
        if (myOrder == null) myOrder = new Order();
        
        return myOrder;
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
    
    public boolean save(File savePath) {
        try {
            
            if (!savePath.exists()) savePath.createNewFile();
            
            FileOutputStream fOut = new FileOutputStream(savePath);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            
            oOut.writeObject(items);
            
            oOut.close();
            fOut.close();
            System.out.println("Order saved to file:" + savePath.getPath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Order could not be saved - file not found");
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Order could not be saved - IOException");
            return false;
        }
        
        return true;
    }
    
    public boolean load(File loadPath) {
        try {
            FileInputStream fIn = new FileInputStream(loadPath);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            
            items = (List) oIn.readObject();
            
            oIn.close();
            fIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Failed to load order - FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("Failed to load order - IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to load order - ClassNotFoundException");
        }
        
        
        return true;
    }
}
