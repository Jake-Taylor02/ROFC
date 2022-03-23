/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;

/**
 *
 * @author b1086175
 */
public abstract class ItemView {
    protected Item myItem;

    public ItemView(Item myItem) {
        this.myItem = myItem;
    }
    
    
    
    public abstract void editItem();
    
    public abstract JPanel getItemSummary();
}
