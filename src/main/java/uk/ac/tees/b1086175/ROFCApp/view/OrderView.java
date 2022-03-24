/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import java.util.List;
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
    
    public static ItemView getView(Item myItem) {
        ItemView newItemView = null;

        if (myItem instanceof Chair) {
            newItemView = new ChairView(myItem);

        } else if (myItem instanceof Table) {
            newItemView = new TableView(myItem);

        } else if (myItem instanceof Desk) {
            newItemView = new DeskView(myItem);
        }
        
        return newItemView;
    }
    
}
