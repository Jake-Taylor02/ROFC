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
 *
 * @author b1086175 | Jake Taylor
 */
public class OrderView {
    private final Map<Class, ItemView> viewMap = new HashMap<>();
    
    public OrderView() {
        
    }
    
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
    
    public void remove(Item toRemove) {
        if (!viewMap.containsKey(toRemove.getClass())) return;
        
        viewMap.remove(toRemove.getClass());
    }
    
    public ItemView getView(Item item) {
        return viewMap.get(item.getClass());
    }
    
    public void clearAll() {
        viewMap.clear();
    }
    
    public void populate() {
        Order myOrder = Order.getInstance();
        for (int i = 0; i < myOrder.size(); i++) {
            this.add(myOrder.get(i));
        }
    }
    
//    public static ItemView getView(Item myItem) {
//        ItemView newItemView = null;
//
//        if (myItem instanceof Chair) {
//            newItemView = new ChairView(myItem);
//
//        } else if (myItem instanceof Table) {
//            newItemView = new TableView(myItem);
//
//        } else if (myItem instanceof Desk) {
//            newItemView = new DeskView(myItem);
//        }
//        
//        return newItemView;
//    }
    
}
