/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import uk.ac.tees.b1086175.ROFCApp.view.ItemView;
import uk.ac.tees.b1086175.ROFCApp.view.OrderView;

/**
 *
 * @author b1086175
 */
public class Order {
    private static Order myOrder;
    public OrderView myViews;
    
    private File path;
    private List<Item> items;

    private Order() {
        path = null;
        items = new ArrayList<>();
        myViews = new OrderView();
    }
    
    public static Order getInstance() {
        if (myOrder == null) myOrder = new Order();
        
        return myOrder;
    }
    
    public void addItem(Item itemIn) {
        items.add(itemIn);
    }
    
    public boolean removeItem(int index) {
        if (index < 0 || index >= items.size()) return false;
        
        items.remove(index);
        return true;
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    // this isnt used anymore
    public void replaceItem(int index, Item newItem) {
        items.set(index, newItem);
    }
    
    public void clear() {
        items.clear();
    }
    
    public Item get(int index) {
        return items.get(index);
    }

    public File getPath() {
        return path;
    }
    
    public int size() {
        return items.size();
    }
    
    public int calcTotal() {
        int result = 0;
        for (Item e : items) {
            result += e.getTotalPrice();
        }
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
        
        path = savePath;
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
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            System.out.println("Failed to load order - IOException");
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to load order - ClassNotFoundException");
            ex.printStackTrace();
            return false;
        }
        
        path = loadPath;
        return true;
    }
}
