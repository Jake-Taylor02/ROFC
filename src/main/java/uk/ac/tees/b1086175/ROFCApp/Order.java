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
import uk.ac.tees.b1086175.ROFCApp.view.OrderView;

/** Singleton class representing an Order of Items.
 * Wraps the List of items and provides the relevant methods.
 * 
 * @author b1086175 | Jake Taylor
 */
public class Order {
    private static Order myOrder;

    /**
     * Class mapping items to their correct view
     */
    public final OrderView myViews;
    
    private File path;
    private List<Item> items;

    private Order() {
        path = null;
        items = new ArrayList<>();
        myViews = new OrderView();
    }
    
    /**
     * Returns the current instance of this class.
     * @return
     */
    public static Order getInstance() {
        if (myOrder == null) myOrder = new Order();
        
        return myOrder;
    }
    
    /**
     * Add an item to the order
     * @param itemIn
     */
    public void addItem(Item itemIn) {
        items.add(itemIn);
        myViews.add(itemIn);
    }
    
    /**
     * Removes an item from the order using its index
     * @param index
     * @return
     */
    public boolean removeItem(int index) {
        if (index < 0 || index >= items.size()) return false;
        
        items.remove(index);
        return true;
    }
    
    /**
     * Removes an item from the order using its reference
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    /**
     * Clears all items from the order
     */
    public void clear() {
        items.clear();
    }
    
    /**
     * Returns the item at the given index
     * @param index
     * @return
     */
    public Item get(int index) {
        return items.get(index);
    }

    /**
     * Returns the file path.
     * @return
     */
    public File getPath() {
        return path;
    }
    
    /**
     * Returns the number of items in the order.
     * @return
     */
    public int size() {
        return items.size();
    }
    
    /**
     * Returns the sum of all items within the order.
     * @return
     */
    public int calcTotal() {
        int result = 0;
        for (Item e : items) {
            result += e.getTotalPrice();
        }
        return result;
    }
    
    /**
     * Saves the order to the given file
     * @param savePath
     * @return
     */
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
    
    /**
     * Overwrites current order with order from current 
     * @param loadPath
     * @return
     */
    public boolean load(File loadPath) {
        try {
            FileInputStream fIn = new FileInputStream(loadPath);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            
            items = (List) oIn.readObject();
            
            oIn.close();
            fIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Failed to load order - FileNotFoundException");
            return false;
        } catch (IOException ex) {
            System.out.println("Failed to load order - IOException");
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to load order - ClassNotFoundException");
            return false;
        }
        
        path = loadPath;
        return true;
    }
}
