/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import java.util.HashMap;
import java.util.Map;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;
import uk.ac.tees.b1086175.ROFCApp.Table;

/**
 * Class containing Map to link Item subclasses to the correct ItemView.
 * @author b1086175 | Jake Taylor
 */
public class OrderView {
    private final Map<Class, ItemView> viewMap = new HashMap<>();
    
    /**
     * Constructor
     */
    public OrderView() {
        
    }
    
    /** Add new Item instance to the map.
     * Item subclass is only added if it is not already present in the map.
     * 
     * @param newItem
     */
    public void add(Item newItem) {
        if (viewMap.containsKey(newItem.getClass())) return;
        
        ItemView newItemView = null;

        if (newItem instanceof Chair) {
            newItemView = new ChairView();

        } else if (newItem instanceof Table) {
            newItemView = new TableView();

        } else if (newItem instanceof Desk) {
            newItemView = new DeskView();
        }
        
        viewMap.put(newItem.getClass(), newItemView);
    }
    
    /**
     * Removes Class of specified Item from map
     * @param toRemove
     */
    public void remove(Item toRemove) {
        if (!viewMap.containsKey(toRemove.getClass())) return;
        
        viewMap.remove(toRemove.getClass());
    }
    
    /**
     * Returns the correct ItemView based on the Class of item parameter
     * @param item
     * @return
     */
    public ItemView getView(Item item) {
        return viewMap.get(item.getClass());
    }
    
    /**
     * Clears the map.
     */
    public void clearAll() {
        viewMap.clear();
    }
    
    /**
     * Iterates through the order, populating the map.
     */
    public void populate() {
        Order myOrder = Order.getInstance();
        for (int i = 0; i < myOrder.size(); i++) {
            this.add(myOrder.get(i));
        }
    }
    
}
